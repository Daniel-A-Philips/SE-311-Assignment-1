import java.io.File;

public class csvReader extends fileReader {

    public csvReader(File file) {
        super(file);
        readFile();
    }

    @Override
    protected String processLine(String line) {
        return line.replaceAll(",", " ");
    }

}