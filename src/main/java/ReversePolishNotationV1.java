import java.util.Stack;

public class ReversePolishNotationV1 {

    public static double calculate(String expression) {
        Stack<Double> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperation(token)) {
                applyOperation(token, stack);
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperation(String s) {
        return "+-*/sqrt".contains(s);
    }

    private static boolean isBinaryOperation(String s) {
        return !"sqrt".equals(s);
    }

    private static void applyOperation(final String operation, Stack<Double> stack) {
        double secondOperand = stack.pop();
        double firstOperand = isBinaryOperation(operation) ? stack.pop() : 0;
        double result = 0;
        switch (operation) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
            case "sqrt":
                result = Math.sqrt(secondOperand);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        stack.push(result);
    }
}
