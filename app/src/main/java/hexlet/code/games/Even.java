package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

/*
 * =================================== Game "Check for an even number" ===================================
 * The class implements console a game.
 * In this game, the user must correctly answer all questions, even random number or not.
 */
public final class Even {
    private static final int MAX_NUMBER = 100; // maximal number for question
    private static SecureRandom rand = new SecureRandom();

    private Even() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /*
     * The method for starting the game
     */
    public static void run() {
        String gameIntroduction = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // create questions and answers
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int randomNumber = rand.nextInt(MAX_NUMBER);
            gameData[roundNumber][Engine.DATA_QUEST_IND] = Integer.toString(randomNumber);

            gameData[roundNumber][Engine.DATA_ANSW_IND] = isEven(randomNumber) ? "yes" : "no";
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // run game
    }

    /*
     * The method returns true if the parameter is an even number, else returns false
     */
    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
