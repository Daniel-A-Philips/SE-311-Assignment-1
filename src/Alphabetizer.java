import java.util.ArrayList;
import java.util.Comparator;

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

