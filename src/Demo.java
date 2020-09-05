import gui.CopyFilesFrame;

import javax.swing.*;
import java.awt.*;

public class Demo {
    public static void main(String[] args) {
     /*   CopyFiles cf = new CopyFiles("C:\\Users\\Shniros\\Downloads\\jpg.jpg","E:\\copy.jpg");
        try {
            cf.copy();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
      // gui.ProgressBar progressBar = new gui.ProgressBar();
        CopyFilesFrame copyFilesFrame = new CopyFilesFrame();
        copyFilesFrame.display();
    }

}
