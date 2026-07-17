import java.io.File;

public class CsvReader extends FileReader {

    public CsvReader(File file) {
        super(file);
        readFile();
    }

    @Override
    protected String processLine(String line) {
        return line.replaceAll(",", " ");
    }

}