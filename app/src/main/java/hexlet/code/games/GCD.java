package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

public final class GCD {
    // Игра: "НОД"
    private static final int MAX_NUMBER = 100;
    private static SecureRandom rand = new SecureRandom();

    private GCD() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void run() {
        String gameIntroduction = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // формирование вопросов и ответов
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int firstNumber = rand.nextInt(MAX_NUMBER);
            int secondNumber = rand.nextInt(MAX_NUMBER);

            int answerNumber = gcd(firstNumber, secondNumber);

            gameData[roundNumber][Engine.DATA_QUEST_IND] = firstNumber + " " + secondNumber;
            gameData[roundNumber][Engine.DATA_ANSW_IND] = Integer.toString(answerNumber);
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // запуск игры
    }

    private static int gcd(int firstNumber, int secondNumber) {
        // метод возвращает наибольший общий делитель двух чисел
        while (secondNumber != 0) {
            int remainder  = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = remainder;
        }
        return firstNumber;
    }
}
