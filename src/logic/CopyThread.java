package logic;

import gui.ProgressBar;

public class CopyThread extends Thread {

    FilesCopyClass copyFiles;
    public void start(String source, String dest) {
        copyFiles = new FilesCopyClass(source,dest);
        copyFiles.copy();
        new ProgressBar();
    }
    public void trySleep(){
        if(!this.isAlive()){
            try {
                sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("interrupt");
            this.interrupt();
        }
    }
}
