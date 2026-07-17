import java.util.ArrayList;
import java.util.Comparator;

/*
public class AlphabetizerOld {
    private final ArrayList<String> shifted;

    AlphabetizerOld(CShift shift) {
        this.shifted = shift.getPermutations();
        sort();
    }

    private void sort() {
        // Descending order
        this.shifted.sort(String::compareTo);
    }

    public ArrayList<String> getSorted() {
        return shifted;
    }

}*/

public class Alphabetizer{
    private final ArrayList<formattedLine> shifted;

    Alphabetizer(CShift shift) {
        this.shifted = shift.getFormattedLines();
        sort();
    }

    private void sort() {
        // Descending order
        this.shifted.sort(Comparator.comparing(a -> a.Data, String.CASE_INSENSITIVE_ORDER));    }

    public ArrayList<formattedLine> getSorted() {
        for(int i = 0; i < shifted.size(); i++) shifted.get(i).Index = i+1;
        return shifted;
    }

}

