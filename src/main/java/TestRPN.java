import java.util.List;
import java.util.Stack;

public class TestRPN {

    public static Double execute(List<String> expressions) {

        Double firstOperand, secondOperand;
        Stack<Double> values = new Stack<>();

        for (String expression : expressions) {
            if ("+-*/sqrt".contains(expression)) {
                secondOperand = values.pop();
                firstOperand = "sqrt".equals(expression) ? null : values.pop();
                values.push(calculateValue(firstOperand, secondOperand, expression));
            } else {
                values.push(Double.parseDouble(expression));
            }
        }

        return values.pop();
    }

    public static Double calculateValue(Double firstOperand, Double secondOperand, String operator) {
        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            case "sqrt" ->Math.sqrt(secondOperand);
            default -> throw new RuntimeException("Operation not (yet) supported");
        };
    }
}
