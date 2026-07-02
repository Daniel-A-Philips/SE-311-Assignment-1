import java.io.File;
import java.util.ArrayList;

public class FileParser {

    private final String fileName;
    private final ArrayList<String> permittedTypes = new ArrayList<>();
    private fileReader reader;

    FileParser(String fileName) {
        this.fileName = fileName;
        this.permittedTypes.add("csv");
        this.permittedTypes.add("txt");
        parseFileName();
    }

    private File createFile() {
        return new File(this.fileName);
    }

    private void parseFileName() {
        String[] splitFileName = this.fileName.split("\\.");
        String fileType = splitFileName[splitFileName.length-1];

        switch (this.permittedTypes.indexOf(fileType)) {
            case 0:
                this.reader = new csvReader(createFile());
            case 1:
                this.reader = new txtReader(createFile());
            case -1:
                return;
        }
    }

    public fileReader getReader() {
        return this.reader;
    }
}
