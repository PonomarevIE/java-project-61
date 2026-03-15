package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private Cli() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}
