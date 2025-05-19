import java.util.Scanner;
import java.util.Random;

public class Main {
    public static int Score = 0;
    public static Scanner myObj = new Scanner(System.in);
    public static Random rand = new Random();

    public static void question() {
        // Generate random numbers from -999.99 to +999.99 with 2 decimal places
        double n1 = Math.round((rand.nextDouble() * 1999.98 - 999.99) * 100) / 100.0;
        double n2 = Math.round((rand.nextDouble() * 1999.98 - 999.99) * 100) / 100.0;

        // Randomly choose operator: + or -
        char operator = rand.nextBoolean() ? '+' : '-';

        // Ask the question
        System.out.print(n1 + " " + operator + " " + n2 + " = ");

        long start = System.currentTimeMillis();
        double Ans = myObj.nextDouble();
        long end = System.currentTimeMillis();

        // Compute correct answer
        double Correct = operator == '+' ? n1 + n2 : n1 - n2;
        Correct = Math.round(Correct * 100) / 100.0;  // Round to 2 dp

        // Check answer with tolerance
        if (Math.abs(Ans - Correct) < 0.01) {
            Score += 1;
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong! Correct Ans: " + Correct);
        }

        double timeTaken = (end - start) / 1000.0;
        System.out.printf("Time taken: %.2f seconds\n", timeTaken);
    }

    public static void main(String[] args) {
        int Counter = 0;

        while (Counter < 11) {
            question();
            Counter += 1;
        }

        double percentage = (Score * 100.0) / Counter;
        System.out.println("Final Score: " + Score + "/" + Counter + " (" + percentage + "%)");
    }
}
