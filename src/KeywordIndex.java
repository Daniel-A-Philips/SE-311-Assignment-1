import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class KeywordIndex {

    private final ArrayList<String> lines;

    KeywordIndex(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void printIndex() {
        // Alphabetical (case-insensitive) map of word -> set of line numbers it appears on
        TreeMap<String, TreeSet<Integer>> index = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).trim().split("\\s+");
            for (String word : words) {
                if (word.isEmpty()) continue;
                index.computeIfAbsent(word, k -> new TreeSet<>()).add(i + 1);
            }
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : index.entrySet()) {
            StringBuilder lineNumbers = new StringBuilder();
            for (Integer lineNum : entry.getValue()) {
                if (!lineNumbers.isEmpty()) lineNumbers.append(", ");
                lineNumbers.append(lineNum);
            }
            System.out.println(entry.getKey() + ", " + lineNumbers);
        }
    }
}