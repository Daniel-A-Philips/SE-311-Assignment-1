public class formattedLine {
    int Index;
    String Data;
    int OriginalLine;

    formattedLine(int Index, String Data, int OriginalLine) {
        this.Index = Index;
        this.Data = Data;
        this.OriginalLine = OriginalLine;
    }

    formattedLine(String Data, int OriginalLine) {
        this.Data = Data;
        this.OriginalLine = OriginalLine;
    }

    public String toString() {
        if (this.Index == 0) return "| " + this.Data +" | " + this.OriginalLine;
        return this.Index + " | " + this.Data +" | " + this.OriginalLine;


    }
}
