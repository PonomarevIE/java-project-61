package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    // Игра: "НОД"
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String gameIntroduction = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        Random rand = new Random();

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
