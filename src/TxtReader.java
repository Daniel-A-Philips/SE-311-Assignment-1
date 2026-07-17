import java.io.File;

public class TxtReader extends FileReader {

    public TxtReader(File file) {
        super(file);
        readFile();
    }

}