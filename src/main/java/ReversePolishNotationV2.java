import java.util.ArrayList;
import java.util.List;

public class ReversePolishNotationV2 {

    public static double calculate(String expression) {

        if(!expression.contains(" ")) {
            return Double.parseDouble(expression);
        }

        List<String> expressionSplit = new ArrayList<>(List.of(expression.split(" ")));

        for (int i = 0; i < expressionSplit.size(); i++) {

            String currentExpression = expressionSplit.get(i);
            if(!isOperation(currentExpression)) {
                continue;
            }

            boolean isBinary = isBinary(currentExpression);
            double result = getResult(isBinary, expressionSplit, currentExpression, i);
            String newExpression = createNewExpression(isBinary, expressionSplit, result, i);
            return calculate(newExpression);
        }

        return 0;
    }

    private static String createNewExpression(boolean isBinary, List<String> expressionSplit, double result, int i) {

        expressionSplit.remove(i);
        expressionSplit.remove(i-1);

        if(isBinary) {
            expressionSplit.remove(i-2);
            expressionSplit.add(i-2, String.valueOf(result));
        } else {
            expressionSplit.add(i-1, String.valueOf(result));
        }

        return String.join(" ", expressionSplit);
    }

    private static double getResult(boolean isBinary, List<String> expressionSplit, String currentExpression, int i) {

        double result = 0, firstOperand = 0;
        double secondOperand = Double.parseDouble(expressionSplit.get(i-1));

        if(isBinary) {
            firstOperand = Double.parseDouble(expressionSplit.get(i-2));

            if("+".equals(currentExpression)) {
                result = firstOperand+secondOperand;
            }
            if("-".equals(currentExpression)) {
                result = firstOperand-secondOperand;
            }
            if("*".equals(currentExpression)) {
                result = firstOperand*secondOperand;
            }
            if("/".equals(currentExpression)) {
                result = firstOperand/secondOperand;
            }
        } else {
            if("sqrt".equals(currentExpression)) {
                result = Math.sqrt(secondOperand);
            }
        }

        return result;
    }

    private static boolean isOperation(String expression) {
        return "+".equals(expression)
                || "-".equals(expression)
                || "*".equals(expression)
                || "/".equals(expression)
                || "sqrt".equals(expression);
    }

    private static boolean isBinary(String expression) {
        return !"sqrt".equals(expression);
    }

}
