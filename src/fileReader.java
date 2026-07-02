import java.io.File;
import java.util.ArrayList;

public abstract class fileReader {

    protected ArrayList<String> lines;
    protected final String fileName;
    protected final File file;

    fileReader(File file) {
        this.file = file;
        this.fileName = file.getName();
    }

    abstract void readFile();

    public ArrayList<String> getLines() {
        return this.lines;
    }
}


