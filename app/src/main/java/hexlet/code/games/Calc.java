package hexlet.code.games;

import hexlet.code.Engine;
import java.security.SecureRandom;

/*
 * =================================== Game "Calculator" ===================================
 * The class implements console a game "Calculator".
 * In this game, the user must correctly answer all questions by adding, subtracting, and multiplying random numbers.
 */
public final class Calc {
    private static final int MAX_NUMBER = 10; // maximal number for question
    private static final int OPERATIONS_QTY = 3; // count of used calculation operations
    private static final String[] OPERATIONS = {"+", "-", "*"}; // symbols of calculation operations
    private static SecureRandom rand = new SecureRandom();

    private Calc() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /*
     * The method for starting the game
     */
    public static void run() {
        String gameIntroduction = "What is the result of the expression?";
        String[][] gameData = new String[Engine.GAME_ROUNDS_QTY][2];

        // create questions and answers
        for (int roundNumber = 0; roundNumber < Engine.GAME_ROUNDS_QTY; roundNumber++) {
            int firstNumber = rand.nextInt(MAX_NUMBER) + 1;
            int secondNumber = rand.nextInt(MAX_NUMBER) + 1;
            int operationNumber = rand.nextInt(OPERATIONS_QTY);
            String operation = OPERATIONS[operationNumber];
            int answerNumber = calculate(firstNumber, secondNumber, operation);

            gameData[roundNumber][Engine.DATA_QUEST_IND] = firstNumber + " " + operation + " " + secondNumber;
            gameData[roundNumber][Engine.DATA_ANSW_IND] = Integer.toString(answerNumber);
        }
        var engine = new Engine(gameIntroduction, gameData);

        engine.runGame(); // run game
    }

    /*
     * The method performs the specified type of arithmetic operation with the specified operands
     */
    private static int calculate(int firstOperand, int secondOperand, String operation) {
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
