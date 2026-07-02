import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class txtReader extends fileReader {
    public txtReader(File file) {
        super(file);
        readFile();
    }

    @Override
    void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
