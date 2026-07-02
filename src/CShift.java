import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CShift {
    private final ArrayList<String> lineInputs;
    private final ArrayList<String> shiftLines;
    private final Map<String, ArrayList<String>> shiftLinesGrouped;

    CShift(ArrayList<String> lineInputs) {
        shiftLines = new ArrayList<String>();
        shiftLinesGrouped = new HashMap<>();
        this.lineInputs = lineInputs;
        createKWIC();
    }

    private void createKWIC() {
        this.lineInputs.forEach(line -> addLine(line, createPermutations(line)));
    }

    private void addLine(String line, ArrayList<String> permutated) {
        this.shiftLines.addAll(permutated);
        this.shiftLinesGrouped.put(line, permutated);
    }

    private ArrayList<String> createPermutations(String line) {
        ArrayList<String> splitLine = new ArrayList<>(Arrays.asList(line.split(" ")));
        ArrayList<String> toReturn = new ArrayList<String>();
        for(int i = 0; i < splitLine.size(); i++) {
            toReturn.add(String.join(" ",splitLine));
            // Add the first to the end, then remove it
            splitLine.add(splitLine.getFirst());
            splitLine.removeFirst();
        }
        return toReturn;
    }

    public ArrayList<String> getPermutations() {
        return this.shiftLines;
    }

    public Map<String, ArrayList<String>> getPermutationsByLine() {
        return this.shiftLinesGrouped;
    }
}
