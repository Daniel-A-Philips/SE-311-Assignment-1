import java.io.File;
import java.util.ArrayList;

public class FileParser {

    private final String fileName;
    private final ArrayList<String> permittedTypes = new ArrayList<>();
    private FileReader reader;

    FileParser(String fileName) throws Exception {
        this.fileName = fileName;
        this.permittedTypes.add("csv");
        this.permittedTypes.add("txt");
        parseFileName();
    }

    private File createFile() {
        return new File(this.fileName);
    }

    private void parseFileName() throws Exception {
        String[] splitFileName = this.fileName.split("\\.");
        String fileType = splitFileName[splitFileName.length-1];

        switch (this.permittedTypes.indexOf(fileType)) {
            case 0: // CSV
                this.reader = new CsvReader(createFile());
                break;
            case 1: // TXT type file
                this.reader = new TxtReader(createFile());
                break;
            case -1:
                System.err.println("File: " + this.fileName + " is not able to be parsed.\n" +
                        "The current file types that can be parsed are: ");
                this.permittedTypes.forEach(System.err::println);
                throw new Exception("Wrong file type");
        }
    }

    public FileReader getReader() {
        return this.reader;
    }
}
