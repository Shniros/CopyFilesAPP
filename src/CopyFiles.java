import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFiles {
    private String fileSource;
    private String fileDest;
    private LoadThread  loadThread;
    public CopyFiles(String fileSource,String fileDest){
        this.fileSource = fileSource;
        this.fileDest = fileDest;
    }
    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public void setFileDest(String fileDest) {
        this.fileDest = fileDest;
    }

    public void copy() throws Exception {

        FileInputStream in = new FileInputStream(fileSource);
        try {
            FileOutputStream out = new FileOutputStream(fileDest);
            try {
                byte[] buf = new byte[1024];
                int r;
                loadThread.sleep(1000);
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        out.write(buf, 0, r);
                    }
                } while (r > 0);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
