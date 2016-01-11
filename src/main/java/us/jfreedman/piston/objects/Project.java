package us.jfreedman.piston.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 1/11/2016.
 */
public class Project {

    private final List<File> fileList;

    public Project() {
        this(new ArrayList<>());
    }

    public Project(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public List<File> add(File project) {
        fileList.add(project);
        return fileList;
    }

    public File get(int index) {
        return fileList.get(index);
    }

}
