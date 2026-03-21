package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

/*
 * =================================== Game "Prime" ===================================
 * The class implements console a game.
 * In this game, the user must correctly answer all questions, of whether a random number is prime.
 */
public final class Prime {
    private static final int MAX_NUMBER = 100; // maximal number for question
    private static SecureRandom rand = new SecureRandom();

    private Prime() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /*
     * The method for starting the game
     */
    public static void run() {
        String gameIntroduction = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // create questions and answers
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int randomNumber = rand.nextInt(MAX_NUMBER);
            gameData[roundNumber][Engine.DATA_QUEST_IND] = Integer.toString(randomNumber);

            gameData[roundNumber][Engine.DATA_ANSW_IND] = isPrime(randomNumber) ? "yes" : "no";
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // run game
    }

    /*
     * The method returns true if the parameter is a prime number, else returns false
     */
    private static boolean isPrime(int number) {
        if (number < 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
