import java.util.Scanner;
public class DivisorsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input a number
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("\nPositive and Negative Divisors of " + number 
        + ":");
       
        for (int i = 1; i <= Math.abs(number); i++) {
            if (number % i == 0) {
                System.out.println(i + " and " + (-i));
            }
        }
        scanner.close();
    }
}
