package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    // Игра: "Арифметическая прогрессия"
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_MAX_START_NUMBER = 30;
    private static final int PROGRESSION_MAX_STEP = 10;

    public static void run() {
        String gameIntroduction = "What number is missing in the progression?";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        Random rand = new Random();

        // формирование вопросов и ответов
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            String[] progression = makeProgression();

            int hiddenPosition = rand.nextInt(PROGRESSION_LENGTH);
            gameData[roundNumber][Engine.DATA_ANSW_IND] = progression[hiddenPosition];

            progression[hiddenPosition] = "..";
            gameData[roundNumber][Engine.DATA_QUEST_IND] = String.join(" ", progression);
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // запуск игры
    }

    private static String[] makeProgression() {
        // метод формирует массив, содержащий арифметическую прогрессию
        Random rand = new Random();
        var progression = new String[PROGRESSION_LENGTH];

        int step = rand.nextInt(PROGRESSION_MAX_STEP); // приращение

        // первый элемент прогрессии определяется случайным образом
        int start = rand.nextInt(PROGRESSION_MAX_START_NUMBER);

        // остальные элементы вычисляются на основе выбранного приращения
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            int current = start + i * step;
            progression[i] = Integer.toString(current);
        }
        return progression;
    }
}
