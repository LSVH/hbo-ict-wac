import java.io.File;

public class Playground {
    private File files;

    public Playground() {
        File currentDirFile = new File(".");
        this.files = currentDirFile.getAbsoluteFile();
        System.out.println(files);
    }

    public File getFiles() {
        return files;
    }
}