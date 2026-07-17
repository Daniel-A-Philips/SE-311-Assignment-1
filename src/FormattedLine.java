public class FormattedLine {
    private int index;
    private String data;
    private int originalLine;

    FormattedLine(int Index, String Data, int OriginalLine) {
        this.index = Index;
        this.data = Data;
        this.originalLine = OriginalLine;
    }

    FormattedLine(String Data, int OriginalLine) {
        this.data = Data;
        this.originalLine = OriginalLine;
    }

    public String toString() {
        if (this.index == 0) return "| " + this.data +" | " + this.originalLine;
        return this.index + " | " + this.data +" | " + this.originalLine;
    }

    public int getIndex() { return this.index; }
    public void setIndex(int index) { this.index = index; }

    public String getData() { return this.data; }
    public int getOriginalLine() { return this.originalLine; }
}
