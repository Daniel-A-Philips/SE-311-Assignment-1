import java.util.ArrayList;
import java.util.List;

public class test{
    void main() {
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("Crouching Tiger Hidden Dragon");
        testData.add("Humanistic Approach To Life");
        CShift test = new CShift(testData);

        Alphabetizer alphabetizer = new Alphabetizer(test);
        printArrayList(alphabetizer.getSorted());
    }

    void printArrayList(List<String> list) {
        list.forEach(System.out::println);
    }
}
