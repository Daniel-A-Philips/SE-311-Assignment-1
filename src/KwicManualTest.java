import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KwicManualTest {
    void main() {
        String[] testInput = new String[1];
        testInput[0] = "./Test Files/testInput.csv";
        Main.main(testInput);
    }

    void inputtedData() {
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("Crouching Tiger Hidden Dragon");
        testData.add("Humanistic Approach To Life");
        CShift test = new CShift(testData);

        //printArrayList(test.getFormattedLines());

        Alphabetizer alphabetizer = new Alphabetizer(test);


        printArrayList(alphabetizer.getSorted());


        //if(checkData(alphabetizer.getSorted())) System.out.println("Everything matches");
    }

    void fromTXT(String fileName) {
        try {
            FileParser parser = new FileParser(fileName);
            FileReader reader = parser.getReader();
            System.out.println("\n");
            CShift shift_reader = new CShift(reader.getLines());
            Alphabetizer alphabetizer = new Alphabetizer(shift_reader);

            printArrayList(alphabetizer.getSorted());
        } catch (Exception _) {}
    }

    void fromCSV(String fileName) {
        try {
            FileParser parser = new FileParser(fileName);
            FileReader reader = parser.getReader();
            System.out.println("\n");
            CShift shift_reader = new CShift(reader.getLines());
            Alphabetizer alphabetizer = new Alphabetizer(shift_reader);

            printArrayList(alphabetizer.getSorted());
        } catch (Exception _) {}

    }


    void printArrayList(List list) {
        System.out.println("\n");
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

        return correct.containsAll(data);
    }
}
