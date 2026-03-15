package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static String userName;
    public static void main(String[] args) {
        // формирование меню
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        // выбор пункта меню
        Scanner scanner = new Scanner(System.in);
        String menuItem = scanner.nextLine();

        if (menuItem.equals("0")) {
            System.exit(0);
        }
        System.out.println();

        boolean userWin;
        // запуск выбранной игры
        switch (menuItem) {
            case "1":
                greet();
                System.exit(0);
            case "2":
                Even.run();
                break;
            case "3":
                Calc.run();
                break;
            case "4":
                GCD.run();
                break;
            case "5":
                Progression.run();
                break;
            default:
                throw new InputMismatchException("Incorrect menu item: " + menuItem);
        }

        scanner.close();
    }

    private static void greet() {
        var engine = new Engine();
        engine.greet();
    }
}
