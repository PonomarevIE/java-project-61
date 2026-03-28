package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

/*
 * =================================== Game "Progression" ===================================
 * The class implements console a game.
 * In this game, the user must correctly answer all questions by specifying the missing element of the
 * arithmetic progression.
 */
public final class Progression {
    private static final int PROGRESSION_LENGTH = 10; // count of elements in progression
    private static final int PROGRESSION_MAX_START_NUMBER = 30; // maximal first progression number
    private static final int PROGRESSION_MAX_STEP = 10; // maximal step of progression
    private static SecureRandom rand = new SecureRandom();

    /*
     * The method for starting the game
     */
    private Progression() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void run() {
        String gameIntroduction = "What number is missing in the progression?";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // create questions and answers
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            String[] progression = makeProgression();

            int hiddenPosition = rand.nextInt(PROGRESSION_LENGTH);
            gameData[roundNumber][Engine.DATA_ANSW_IND] = progression[hiddenPosition];

            progression[hiddenPosition] = "..";
            gameData[roundNumber][Engine.DATA_QUEST_IND] = String.join(" ", progression);
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // run game
    }

    /*
     * The method forms an arithmetic progression and returns it as an array of numbers in text format.
     */
    private static String[] makeProgression() {
        var progression = new String[PROGRESSION_LENGTH]; // array of progression elements in text format

        int step = rand.nextInt(PROGRESSION_MAX_STEP) + 1; // step of progression

        // the first element of the progression is determined randomly
        int start = rand.nextInt(PROGRESSION_MAX_START_NUMBER) + 1;

        // the remaining elements are calculated based on the selected step
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            int current = start + i * step;
            progression[i] = Integer.toString(current);
        }
        return progression;
    }
}
