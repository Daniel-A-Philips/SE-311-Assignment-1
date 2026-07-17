import java.io.File;
import java.util.ArrayList;

public class FileParser {

    private final String fileName;
    private FileReader reader;

    FileParser(String fileName) throws Exception {
        this.fileName = fileName;
        parseFileName();
    }

    private File createFile() {
        return new File(this.fileName);
    }

    private void parseFileName() throws Exception {
        String[] splitFileName = this.fileName.split("\\.");
        String fileType = splitFileName[splitFileName.length-1];

        switch (fileType) {
            case "csv":
                this.reader = new CsvReader(createFile());
                break;
            case "txt":
                this.reader = new TxtReader(createFile());
                break;
            default:
                System.err.println("File: " + this.fileName + " is not able to be parsed.\n");
                throw new Exception("Wrong file type");
        }
    }

    public FileReader getReader() {
        return this.reader;
    }
}
