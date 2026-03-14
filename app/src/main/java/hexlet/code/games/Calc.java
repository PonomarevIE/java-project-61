package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    // Игра: "Калькулятор"
    private static final int MAX_NUMBER = 10;
    private static final int OPERATIONS_QTY = 3;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void run() {
        String gameIntroduction = "What is the result of the expression?";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        Random rand = new Random();

        // формирование вопросов и ответов
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int firstNumber = rand.nextInt(MAX_NUMBER);
            int secondNumber = rand.nextInt(MAX_NUMBER);
            int operationNumber = rand.nextInt(OPERATIONS_QTY);
            String operation = OPERATIONS[operationNumber];
            int answerNumber = calculate(firstNumber, secondNumber, operation);

            gameData[roundNumber][Engine.DATA_QUEST_IND] = firstNumber + " " + operation + " " + secondNumber;
            gameData[roundNumber][Engine.DATA_ANSW_IND] = Integer.toString(answerNumber);
        }

        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // запуск игры
    }

    private static int calculate(int firstOperand, int secondOperand, String operation) {
        // метод выполняет указанный тип операции с указанными
        switch (operation) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            default:
                throw new IllegalArgumentException("Illegal operation: " + operation);
        }
    }
}
