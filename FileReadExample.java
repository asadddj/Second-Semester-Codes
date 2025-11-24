
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadExample {
    public static void main(String[] args) {
        String Filepath = "sales.txt";
        try {
            File file = new File(Filepath); // Replace with your file name
            Scanner scanner = new Scanner(file);

            // If the file opens successfully
            System.out.println("File opened successfully.");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            // This block is executed if the file could not be opened
            System.out.println("Error: File could not be opened. File not found.");
        }
    }
}
