package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

public final class Prime {
    // Игра: "Простое ли число?"
    private static final int MAX_NUMBER = 100;
    private static SecureRandom rand = new SecureRandom();

    private Prime() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void run() {
        String gameIntroduction = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // формирование вопросов и ответов
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int randomNumber = rand.nextInt(MAX_NUMBER);
            gameData[roundNumber][Engine.DATA_QUEST_IND] = Integer.toString(randomNumber);

            gameData[roundNumber][Engine.DATA_ANSW_IND] = isPrime(randomNumber) ? "yes" : "no";
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // запуск игры
    }

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
