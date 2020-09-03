import javax.swing.*;
import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        CopyFiles cf = new CopyFiles("C:\\Users\\Shniros\\Downloads\\jpg.jpg","E:\\copy.jpg");
        try {
            cf.copy();
        } catch (Exception e) {
            e.printStackTrace();
        }
       ProgressBar progressBar = new ProgressBar();
    }

}
