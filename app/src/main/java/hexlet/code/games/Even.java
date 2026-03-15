package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

public final class Even {
    // Игра: "Проверка на чётность"
    private static final int MAX_NUMBER = 100;
    private static SecureRandom rand = new SecureRandom();

    private Even() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void run() {
        String gameIntroduction = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // формирование вопросов и ответов
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int randomNumber = rand.nextInt(MAX_NUMBER);
            gameData[roundNumber][Engine.DATA_QUEST_IND] = Integer.toString(randomNumber);

            gameData[roundNumber][Engine.DATA_ANSW_IND] = isEven(randomNumber) ? "yes" : "no";
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // запуск игры
    }

    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
