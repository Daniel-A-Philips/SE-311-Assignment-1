import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java -cp out Main <inputFile>");
            return;
        }

        ArrayList<String> lines;
        try {
            FileParser parser = new FileParser(args[0]);
            FileReader reader = parser.getReader();
            lines = reader.getLines();
        } catch (Exception e) {
            System.err.println("Could not read file: " + args[0]);
            return;
        }

        // Build the shared data structures once, up front
        CShift shift = new CShift(lines);
        Alphabetizer alphabetizer = new Alphabetizer(shift);
        KeywordSearch search = new KeywordSearch(lines);
        KeywordIndex index = new KeywordIndex(lines);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command (kwic, search <keyword>, index, quit):");

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (command.isEmpty()) continue;

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.equalsIgnoreCase("kwic")) {
                printKWIC(alphabetizer);
            } else if (command.equalsIgnoreCase("index")) {
                index.printIndex();
            } else if (command.toLowerCase().startsWith("search ")) {
                String keyword = command.substring("search ".length()).trim();
                if (keyword.isEmpty()) {
                    System.out.println("Usage: search <keyword>");
                } else {
                    search.search(keyword);
                }
            } else {
                System.out.println("Unknown command: " + command);
                System.out.println("Supported commands: kwic, search <keyword>, index, quit");
            }
            System.out.println("\nEnter a command (kwic, search <keyword>, index, quit):");

        }

        scanner.close();
    }

    private static void printKWIC(Alphabetizer alphabetizer) {
        System.out.println("Index | Circular Shifted Lines | Original Line Index");
        alphabetizer.getSorted().forEach(System.out::println);
    }
}