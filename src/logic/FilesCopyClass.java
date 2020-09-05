package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FilesCopyClass {
    private String fileSource;
    private String fileDest;

    public FilesCopyClass(String fileSource,String fileDest){
        this.fileSource = fileSource;
        this.fileDest = fileDest;
    }
    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public void setFileDest(String fileDest) {
        this.fileDest = fileDest;
    }

    public void copy(){

        try {
            FileInputStream in = new FileInputStream(fileSource);
            FileOutputStream out = new FileOutputStream(fileDest);
            try {
                byte[] buf = new byte[1024];
                int r;
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        out.write(buf, 0, r);
                    }
                } while (r > 0);
            } finally {
                out.close();
                in.close();
            }
        } catch (Exception ex){

            ex.printStackTrace();
        }
    }
}