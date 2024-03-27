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
        double result = 0;
        switch (operator) {
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
        }
        return result;
    }
}
