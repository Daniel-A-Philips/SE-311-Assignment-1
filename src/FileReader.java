import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileReader {

    protected ArrayList<String> lines;
    protected final String fileName;
    protected final File file;

    FileReader(File file) {
        this.file = file;
        this.fileName = file.getName();
        lines = new ArrayList<String>();
    }

    /**
     * Shared reading logic.
     * Opens the file, reads it line by line.
     * Delegates any per-line transformation to processLine().
     */
    final void readFile() {
        String line;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(this.file))) {
            while ((line = reader.readLine()) != null) {
                lines.add(processLine(line));
            }
        } catch (IOException e) {
            System.err.println("Error in fileReader.readFile():\n"+e);
        }
    }

    /**
     * Hook for subclasses to transform each line as it's read.
     * Default is a no-op (return the line unchanged).
     */
    protected String processLine(String line) {
        return line;
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }
}