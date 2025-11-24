import java.util.Scanner;

public class finalppr28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
    
        // Declare a 2D array
        int[][] matrix = new int[rows][cols];

        // Taking input for array elements
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Printing the 2D array in matrix form
        System.out.println("The matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(); // Move to next line after each row
        }

        scanner.close();
    }
}

