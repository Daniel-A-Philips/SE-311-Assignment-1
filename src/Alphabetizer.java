import java.util.ArrayList;

public class Alphabetizer {
    private final ArrayList<String> shifted;

    Alphabetizer(CShift shift) {
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

}
