import java.util.ArrayList;
import java.util.Arrays;
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

        if(checkData(alphabetizer.getSorted())) System.out.println("Everything matches");
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

    boolean checkData(ArrayList<String> data) {
        if (data.size() != 8) return false;
        ArrayList<String> correct = new ArrayList<String>(Arrays.asList(("Approach To Life Humanistic\n" +
                            "Crouching Tiger Hidden Dragon\n" +
                            "Dragon Crouching Tiger Hidden\n" +
                            "Hidden Dragon Crouching Tiger\n" +
                            "Humanistic Approach To Life\n" +
                            "Life Humanistic Approach To\n" +
                            "Tiger Hidden Dragon Crouching\n" +
                            "To Life Humanistic Approach").split("\n")));

        if(correct.containsAll(data)) return true;
        return false;
    }
}
