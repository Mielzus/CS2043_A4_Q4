import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jason on 2017-06-06.
 */
public class Main {

    private static boolean flag = false;
    private static int count = 0;
    private static ReservedWords tracker;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        tracker = new ReservedWords();
//        System.out.println("Enter the path to the source file to check");
//        String path = scanner.nextLine();
        String path = "C:\\Users\\Jason\\Dropbox (UNB)\\4. Summer 2017\\CS 2043\\Assignments\\Assignment 4\\Source Code\\BinaryCalculatorView.java";
        System.out.println(path);

        try (Scanner fileScanner = new Scanner(new File(path))) {
            // ToDo do something with the inputted file
            while(fileScanner.hasNextLine()) {
                decipherLine(fileScanner.nextLine());
            }
            System.out.println(tracker.getN1());
            System.out.println(tracker.getN2());
        }
        catch(FileNotFoundException e) {
            System.out.println("Invalid file, please enter the path to a valid file");
        }
    }

    private static void decipherLine(String line) {
        // Check for reserved words

        String[] splitString;
        line = line.replace(";", "");
        splitString = line.trim().split(" |\\(|\\)|\\.");

        List<String> operators = Arrays.asList(ReservedWords.operators);

        for (String item : splitString) {
            if (operators.contains(item)) {
                tracker.addOperator(item);
            }
            else {
                tracker.addOperand(item);
            }
        }

        return;
    }
}
