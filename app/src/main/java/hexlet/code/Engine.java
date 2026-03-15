package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int GAME_ROUNDS_QTY = 3; // кол-во раундов в игре
    public static final int DATA_QUEST_IND = 0; // индекс вопроса в массиве данных раунда
    public static final int DATA_ANSW_IND = 1; // индекс ответа в массиве данных раунда

    private String userName;

    private String[][] gameData; // массив данных игры (каждая строка массива - вопрос и ответ одного раунда)
    private String gameIntroduction; // вводное сообщение игры

    public Engine() {
    }

    public Engine(String intro, String[][] gData) {
        gameIntroduction = intro;
        gameData = gData;
    }

    public void runGame() {
        // метод запуска игры
        greet(); // приветствие и запрос имени пользователя

        Scanner scanner = new Scanner(System.in);
        System.out.println(gameIntroduction);

        for (String[] roundData : gameData) {
            // данные раунда
            String question = roundData[DATA_QUEST_IND];
            String answer = roundData[DATA_ANSW_IND];

            // вывод вопроса, получение ответа пользователя
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // проверка ответа пользователя
            if (answer.equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public void greet() {
        // метод спрашивает имя пользователя и выводит приветствие
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
