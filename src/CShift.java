import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CShift {
    private final ArrayList<String> lineInputs;
    private final ArrayList<String> shiftLines;
    private final Map<String, ArrayList<String>> shiftLinesGrouped;
    private final ArrayList<FormattedLine> formattedLines;

    CShift(ArrayList<String> lineInputs) {
        shiftLines = new ArrayList<String>();
        shiftLinesGrouped = new HashMap<>();
        formattedLines = new ArrayList<FormattedLine>();
        this.lineInputs = lineInputs;
        createKWIC();
    }

    private void createKWIC() {
        for(int i = 0; i < this.lineInputs.size(); i++) {
            String line = lineInputs.get(i);
            addLine(line, createPermutations(line, i+1));
        }
        //this.lineInputs.forEach(line -> addLine(line, createPermutations(line)));
    }

    private void addLine(String line, ArrayList<String> permutated) {
        this.shiftLines.addAll(permutated);
        this.shiftLinesGrouped.put(line, permutated);
    }

    private ArrayList<String> createPermutations(String line, int lineNum) {
        ArrayList<String> splitLine = new ArrayList<>(Arrays.asList(line.split(" ")));
        ArrayList<String> toReturn = new ArrayList<String>();
        String extractedLine;
        for(int i = 0; i < splitLine.size(); i++) {
            extractedLine = String.join(" ",splitLine);
            toReturn.add(extractedLine);
            // Add the first to the end, then remove it
            splitLine.add(splitLine.getFirst());
            splitLine.removeFirst();
            formattedLines.add(new FormattedLine(extractedLine, lineNum));
        }
        return toReturn;
    }

    public ArrayList<String> getPermutations() {
        return this.shiftLines;
    }

    public Map<String, ArrayList<String>> getPermutationsByLine() {
        return this.shiftLinesGrouped;
    }

    public ArrayList<FormattedLine> getFormattedLines() {
        return formattedLines;
    }
}
