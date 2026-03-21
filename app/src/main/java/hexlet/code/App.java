package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The main application class. Creates a menu with a list of games. Launches the game selected by the user
 */
public class App {
    public static void main(String[] args) {
        // printing the menu
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        // selecting a menu item
        Scanner scanner = new Scanner(System.in);
        String menuItem = scanner.nextLine();
        System.out.println();

        // launching the selected game
        switch (menuItem) {
            case "0":
                break;
            case "1":
                greet();
                break;
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
            case "6":
                Prime.run();
                break;
            default:
                throw new InputMismatchException("Incorrect menu item: " + menuItem);
        }

        scanner.close();
    }

    /*
     * The method requesting a username and greeting
     */
    private static void greet() {
        var engine = new Engine();
        engine.greet();
    }
}
