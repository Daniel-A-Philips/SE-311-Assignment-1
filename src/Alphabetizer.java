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
    private final ArrayList<FormattedLine> shifted;

    Alphabetizer(CShift shift) {
        this.shifted = shift.getFormattedLines();
        sort();
    }

    private void sort() {
        // Descending order
        this.shifted.sort(Comparator.comparing(FormattedLine::getData, String.CASE_INSENSITIVE_ORDER));    }

    public ArrayList<FormattedLine> getSorted() {
        for(int i = 0; i < shifted.size(); i++) shifted.get(i).setIndex(i+1);
        return shifted;
    }

}

