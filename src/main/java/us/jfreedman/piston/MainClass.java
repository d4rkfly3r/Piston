package us.jfreedman.piston;

import us.jfreedman.piston.windows.MainWindow;

import java.util.Map;

/**
 * Created by Joshua on 1/11/2016.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Starting....");
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

//        Map<String, String> getenv = System.getenv();
//
//        getenv.forEach((s, s2) -> System.out.println(s + " :: " + s2));

    }
}
