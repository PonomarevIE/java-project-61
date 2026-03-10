package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static String userName;
    public static void main(String[] args) {
        // формирование меню
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        // выбор пункта меню
        Scanner scanner = new Scanner(System.in);
        String menuItem = scanner.nextLine();

        if (menuItem.equals("0")) {
            System.exit(0);
        }

        System.out.println("Your choice: " + menuItem);
        System.out.println();

        greet(); // приветствие

        boolean userWin;
        // запуск выбранной игры
        switch (menuItem) {
            case "1":
                System.exit(0);
            case "2":
                userWin = Even.game();
                break;
            default:
                throw new InputMismatchException("Incorrect menu item: " + menuItem);
        }

        if (userWin) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }

        scanner.close();
    }

    private static void greet() {
        // метод спрашивает имя пользователя и выводит приветствие
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }


}
