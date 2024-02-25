import java.util.Stack;

/**
 * @author Guillaume Houioux ©
 */
public class RPN {

    public static String execute(String input) {

        if (input.isEmpty()) {
            return "";
        }

        String[] inputs = input.split("\\s+");

        if (inputs.length == 1) {
            return inputs[0];
        }

        Stack<Double> stack = new Stack<>();
        for (String operand : inputs) {
            if ("+-/*sqrt".contains(operand)) {
                stack.push(executeOperation(stack, operand));
            } else {
                stack.push(Double.parseDouble(operand));
            }
        }

        return String.valueOf(stack.get(0));
    }

    public static Double executeOperation(Stack<Double> stack, String operand) {

        double right = stack.pop();
        double temp = 0, left = 0;

        if (!"sqrt".equals(operand)) {
            left = stack.pop();
        }

        switch (operand) {
            case "+": temp = left + right;
                break;
            case "-": temp = left - right;
                break;
            case "*": temp = left * right;
                break;
            case "/": temp = left / right;
                break;
            case "sqrt": temp = Math.sqrt(right);
                break;
        }

        return temp;
    }
}
