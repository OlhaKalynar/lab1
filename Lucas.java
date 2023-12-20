import java.util.Scanner;

public class Lucas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLucasNumbers = getValidInput(scanner);

        int[] lucasNumbers = generateLucasNumbers(numberOfLucasNumbers);

        displayLucasNumbers(lucasNumbers);

        displayNumbersOneLessThanSquare(lucasNumbers);

        scanner.close();
    }

    private static int getValidInput(Scanner scanner) {
        int N;
        do {
            System.out.print("Enter the number of Lucas numbers (integer greater than 1): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input is not an integer.");
                System.out.print("Enter the number of Lucas numbers (integer greater than 1): ");
                scanner.next();
            }
            N = scanner.nextInt();
        } while (N <= 1);
        return N;
    }

    private static int[] generateLucasNumbers(int N) {
        int[] lucasNumbers = new int[N];
        lucasNumbers[0] = 2;
        lucasNumbers[1] = 1;
        for (int i = 2; i < N; i++) {
            lucasNumbers[i] = lucasNumbers[i - 1] + lucasNumbers[i - 2];
        }
        return lucasNumbers;
    }

    private static void displayLucasNumbers(int[] lucasNumbers) {
        for (int i = 0; i < lucasNumbers.length; i++) {
            System.out.println("Lucas number(" + (i + 1) + ") = " + lucasNumbers[i]);
        }
    }

    private static void displayNumbersOneLessThanSquare(int[] lucasNumbers) {
        for (int lucasNumber : lucasNumbers) {
            if (isSquare(lucasNumber)) {
                System.out.println("Numbers one less than a square: " + lucasNumber);
            }
        }
    }

    private static boolean isSquare(int number) {
        double squareRoot = Math.sqrt(number + 1);
        return squareRoot == (int) squareRoot;
    }
}
