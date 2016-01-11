package us.jfreedman.piston.windows;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joshua on 1/11/2016.
 */
public class MainWindow extends JFrame {

    private static final File CACHE_FOLDER = new File(new File(System.getenv("HOMEPATH")), ".piston");
    private JTree content;
    private JButton install, download;
    private JScrollPane contentWrapper;

    public MainWindow() {
        super("Piston");

        CACHE_FOLDER.mkdirs();
        System.err.println(CACHE_FOLDER.getAbsolutePath());

        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        install = new JButton("Install");
        install.setSize(130, 35);
        install.setLocation(this.getWidth() - 150, this.getHeight() - 80);
        this.add(install);


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Plugins");

        for (int i = 0; i < 100; i++) {
            DefaultMutableTreeNode curBook = new DefaultMutableTreeNode(i);

            root.add(curBook);

            for (int j = 0; j < 10; j++)
                curBook.add(new DefaultMutableTreeNode(j));
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        content = new JTree(treeModel);
        contentWrapper = new JScrollPane(content);
        contentWrapper.setLocation(10, 10);
        contentWrapper.setSize(580, 540);
        this.add(contentWrapper);

        try {
            downloadToCache(new URL("http://files.minecraftforge.net/maven/org/spongepowered/spongeforge/1.8-1577-3.0.0-BETA-1000/spongeforge-1.8-1577-3.0.0-BETA-1000.jar"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void downloadToCache(URL... fileToDownload) {
        ArrayList<URL> downloads = new ArrayList<>();
        Collections.addAll(downloads, fileToDownload);


        downloads.parallelStream().forEach(url -> {
            try {
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                File downloadFile = new File(CACHE_FOLDER, url.getPath());
                downloadFile.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(downloadFile);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
                rbc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
