import java.util.ArrayList;
import java.util.Arrays;

public class KWIC {
    private ArrayList<String> lineInputs;
    private ArrayList<String> kwicLines = new ArrayList<String>();

    void addData(ArrayList lineInputs) {
        this.lineInputs = lineInputs;
        createKWIC();
    }

    private void createKWIC() {
        this.lineInputs.forEach(line -> kwicLines.addAll(createPermutations(line)));
    }

    private ArrayList<String> createPermutations(String line) {
        System.out.println(line);
        ArrayList<String> splitLine = new ArrayList<>(Arrays.asList(line.split(" ")));
        ArrayList<String> toReturn = new ArrayList<String>();
        for(int i = 0; i < splitLine.size(); i++) {
            System.out.println(splitLine);
            toReturn.add(String.join(" ",splitLine));
            // Add the first to the end, then remove it
            splitLine.add(splitLine.getFirst());
            splitLine.removeFirst();
        }
        return toReturn;
    }
}
