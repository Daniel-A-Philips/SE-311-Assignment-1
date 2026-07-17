import java.util.Scanner;

public class Run {

    static Scanner scanner;
    static FileParser parser;

    static void main() {
        int choice = printIntro();
        if(choice == 2) parser = handleFile();
    }

    static int printIntro() {
        System.out.println("Enter 1 for console input, 2 for file input");
        scanner = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 | choice > 2) throw new Exception("Invalid option");
        } catch (Exception e) {
            System.out.println("Error, invalid input, please try again");
            return printIntro();
        }
        return choice;
    }

    static void handleConsole(){}

    static FileParser handleFile() {
        String fileName;
        scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your file name:");
            fileName = scanner.nextLine();
            return new FileParser(fileName);
        } catch (Exception e) {
            return handleFile();
        }
    }


}
