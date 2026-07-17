import java.util.ArrayList;
import java.util.regex.Pattern;

public class KeywordSearch {

    private final ArrayList<String> lines;

    KeywordSearch(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void search(String keyword) {
        ArrayList<String> matches = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (containsKeyword(line, keyword)) {
                matches.add((i + 1) + " " + highlight(line, keyword));
            }
        }

        if (matches.isEmpty()) {
            System.out.println(keyword + " not found.");
            return;
        }

        String noun = matches.size() == 1 ? "sentence is" : "sentences are";
        System.out.println(matches.size() + " " + noun + " found:");
        matches.forEach(System.out::println);
    }

    private boolean containsKeyword(String line, String keyword) {
        return line.toLowerCase().contains(keyword.toLowerCase());
    }

    private String highlight(String line, String keyword) {
        // Case-insensitive replace that wraps every match in brackets
        return line.replaceAll("(?i)(" + Pattern.quote(keyword) + ")", "[$1]");
    }
}