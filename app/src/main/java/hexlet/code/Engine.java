package hexlet.code;

import java.util.Scanner;

/*
 * The class implements an engine of console a games for user interaction
 */
public final class Engine {
    public static final int GAME_ROUNDS_QTY = 3; // count of game rounds
    public static final int DATA_QUEST_IND = 0; // index of the question in the round data array
    public static final int DATA_ANSW_IND = 1; // index of the answer in the round data array

    private String userName; // name of the user

    private String[][] gameData; // game data array (each row of the array is a question and an answer of one round)
    private String gameIntroduction; // introductory message of the game

    /*
     * Constructor without setting game parameters. Used when only need to greet the user
     */
    public Engine() {
    }

    /*
     * Constructor for setting game parameters
     */
    public Engine(String intro, String[][] gData) {
        gameIntroduction = intro;
        gameData = gData;
    }

    /*
     * The method for starting the game in user interaction
     */
    public void runGame() {
        // greeting and requesting a username
        greet();

        Scanner scanner = new Scanner(System.in);
        System.out.println(gameIntroduction);

        for (String[] roundData : gameData) {
            // game round data
            String question = roundData[DATA_QUEST_IND];
            String answer = roundData[DATA_ANSW_IND];

            // outputting a question, getting a user's answer
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // checking the user's answer
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

    /*
     * The method requesting a username and greeting
     */
    public void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
