import java.util.ArrayList;
import java.util.List;

public class test{
    void main() {
        inputtedData(); // Test with straight inputted data
        fromTXT("./Test Files/testInput.txt"); // Test with TXT
        fromCSV("./Test Files/testInput.csv"); // Test with CSV

        // Test error checking for filename
        tryErrorFile("./Test Files/testInput.tvt");
        tryErrorFile("./Test Files/testInput.csp");
    }

    void inputtedData() {
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("Crouching Tiger Hidden Dragon");
        testData.add("Humanistic Approach To Life");
        CShift test = new CShift(testData);

        Alphabetizer alphabetizer = new Alphabetizer(test);
        printArrayList(alphabetizer.getSorted());

    }

    void fromTXT(String fileName) {
        FileParser parser = new FileParser(fileName);
        fileReader reader = parser.getReader();
        System.out.println("\n");
        CShift shift_reader = new CShift(reader.getLines());
        Alphabetizer alphabetizer = new Alphabetizer(shift_reader);
        printArrayList(alphabetizer.getSorted());
    }

    void fromCSV(String fileName) {
        FileParser parser = new FileParser(fileName);
        fileReader reader = parser.getReader();
        System.out.println("\n");
        CShift shift_reader = new CShift(reader.getLines());
        Alphabetizer alphabetizer = new Alphabetizer(shift_reader);
        printArrayList(alphabetizer.getSorted());
    }


    void printArrayList(List<String> list) {
        list.forEach(System.out::println);
    }

    void tryErrorFile(String fileName) {
        try {
            System.err.print("\n");
            fromCSV(fileName);
        } catch (Exception _){}
    }
}
