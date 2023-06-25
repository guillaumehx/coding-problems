import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int calculate(String expression) {

        List<String> expressionSplit = new ArrayList<>(List.of(expression.split(" ")));

        if(expressionSplit.size() == 1) { return Integer.parseInt(expression); }

        for (int i = 0; i < expressionSplit.size(); i++) {

            String operation = expressionSplit.get(i);
            boolean isBinary = isBinaryOperation(operation);

            if(!isOperation(operation)) { continue; }

            int operationResult = 0;
            int firstOperand = 0;
            int secondOperand = Integer.parseInt(expressionSplit.get(i - 1));

            if(isBinary) {
                firstOperand = Integer.parseInt(expressionSplit.get(i - 2));
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

    private static int getResult(String operation, int firstOperand, int secondOperand) {

        int operationResult = 0;

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
            operationResult = (int) Math.sqrt(secondOperand);
        }

        return operationResult;
    }

    private static void removeFromList(List<String> expressionSplit, int operationResult, int i, boolean isBinary) {

        expressionSplit.add(i + 1, String.valueOf(operationResult));
        expressionSplit.remove(i);
        expressionSplit.remove(i - 1);

        if(isBinary) {
            expressionSplit.remove(i - 2);
        }
    }

}
