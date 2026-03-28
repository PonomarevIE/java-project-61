package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

/*
 * =================================== Game "Greatest common divisor" ===================================
 * The class implements console a game.
 * In this game, the user must correctly answer all questions, specify the largest common divisor of two random numbers.
 */
public final class GCD {
    private static final int MAX_NUMBER = 100; // maximal number for question
    private static SecureRandom rand = new SecureRandom();

    private GCD() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /*
     * The method for starting the game
     */
    public static void run() {
        String gameIntroduction = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // create questions and answers
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int firstNumber = rand.nextInt(MAX_NUMBER) + 1;
            int secondNumber = rand.nextInt(MAX_NUMBER) + 1;

            int answerNumber = gcd(firstNumber, secondNumber);

            gameData[roundNumber][Engine.DATA_QUEST_IND] = firstNumber + " " + secondNumber;
            gameData[roundNumber][Engine.DATA_ANSW_IND] = Integer.toString(answerNumber);
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // run game
    }

    /*
     * The method returns greatest common divisor of two numbers
     */
    private static int gcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int remainder  = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = remainder;
        }
        return firstNumber;
    }
}
