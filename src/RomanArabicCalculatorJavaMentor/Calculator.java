package RomanArabicCalculatorJavaMentor;

public class Calculator {

    public static int calculate(int leftOperand, int rightOperand, String operator) {
        int result = 0;
        try {
        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                result = leftOperand / rightOperand;
                break;
                // проверяем используется ли верный оператор
                default:
                    throw new ArithmeticException("Invalid operator");
                }
        } catch (ArithmeticException e) {
            System.out.println("Invalid operator, please use \"+\", \"-\", \"*\", \"/\".");
            System.exit(0);
        }   return result;
    }
}