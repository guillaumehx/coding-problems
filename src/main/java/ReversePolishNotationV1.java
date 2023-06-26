import java.util.ArrayList;
import java.util.List;

public class ReversePolishNotationV1 {

    public static double calculate(String expression) {

        List<String> expressionSplit = new ArrayList<>(List.of(expression.split(" ")));

        if(expressionSplit.size() == 1) {
            return Double.parseDouble(expression);
        }

        for (int i = 0; i < expressionSplit.size(); i++) {

            String operation = expressionSplit.get(i);
            boolean isBinary = isBinaryOperation(operation);

            if(!isOperation(operation)) { continue; }

            double operationResult = 0;
            double firstOperand = 0;
            double secondOperand = Double.parseDouble(expressionSplit.get(i - 1));

            if(isBinary) {
                firstOperand = Double.parseDouble(expressionSplit.get(i - 2));
            }

            operationResult = getResult(operation, firstOperand, secondOperand);
            removeFromList(expressionSplit, operationResult, i, isBinary);

            return calculate(String.join(" ", expressionSplit));
        }

        return 0;
    }

    private static boolean isOperation(String s) {
        List<String> operators = List.of("+", "-", "*", "/", "sqrt");
        return operators.contains(s);
    }

    private static boolean isBinaryOperation(String s) {
        return !"sqrt".equals(s);
    }

    private static double getResult(String operation, double firstOperand, double secondOperand) {

        double operationResult = 0;

        if("+".equals(operation)) {
            operationResult = firstOperand + secondOperand;
        }
        if("-".equals(operation)) {
            operationResult = firstOperand - secondOperand;
        }
        if("*".equals(operation)) {
            operationResult = firstOperand * secondOperand;
        }
        if("/".equals(operation)) {
            operationResult = firstOperand / secondOperand;
        }
        if("sqrt".equals(operation)) {
            operationResult = Math.sqrt(secondOperand);
        }

        return operationResult;
    }

    private static void removeFromList(List<String> expressionSplit, double operationResult, int i, boolean isBinary) {

        expressionSplit.add(i + 1, String.valueOf(operationResult));
        expressionSplit.remove(i);
        expressionSplit.remove(i - 1);

        if(isBinary) {
            expressionSplit.remove(i - 2);
        }
    }
}
