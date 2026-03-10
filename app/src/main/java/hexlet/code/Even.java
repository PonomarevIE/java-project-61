package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static boolean game() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        for (var i = 1; i <= 3; i++) {
            int number = rand.nextInt(100);
            System.out.println("Question: " + number);
            String answer = scanner.nextLine();

            String correctAnswer = isEven(number) ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                return false;
            }
        }
        return true;
    }

    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
