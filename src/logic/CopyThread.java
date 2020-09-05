package logic;

import gui.ProgressBar;

public class CopyThread extends Thread {

    FilesCopyClass copyFiles;
    public void run(String source, String dest) {
        copyFiles = new FilesCopyClass(source,dest);
        copyFiles.copy();
        new ProgressBar();
    }
}
