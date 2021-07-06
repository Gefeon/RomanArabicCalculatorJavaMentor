package RomanArabicCalculatorJavaMentor;

import java.util.Scanner;

public class MainLogic {

    public static void main(String[] args) {
        // создаем сканнер и разбиваем введенную строку на массив по разделителю (пробел)
        System.out.println("Calculator accepts arabic numbers from '1' to '10' and roman numbers from 'I' to 'X'.");
        System.out.println("Please enter your expression in one line:");
        Scanner userInput = new Scanner(System.in);

        String expression = userInput.nextLine();
        String[] symbols = expression.split(" ");

        //проверка на правильность формата введенного выражения
        try {
            if (symbols.length != 3) {
                throw new ArrayIndexOutOfBoundsException("Wrong input format");
            } else if (isInteger(symbols[0]) != isInteger(symbols[2])) {
                throw new NumberFormatException("Use operands of the same type ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please use the following format: \"A + B\" (spaces are required)");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Please use operands of the same type only (arabic + arabic or roman + roman");
            System.exit(0);
        }

        // объявляем переменные
        int leftOperand;
        int rightOperand;
        String operator;

        try {
            // логика калькуляции арабских цифр
            if (isInteger(symbols[0]) && isInteger(symbols[2])) {
                leftOperand = Integer.parseInt(symbols[0]);
                operator = symbols[1];
                rightOperand = Integer.parseInt(symbols[2]);
                // проверяем подходят ли цифры под условие от 1 до 10
                if (leftOperand > 0 && leftOperand <= 10 && rightOperand > 0 && rightOperand <= 10) {
                    int result = Calculator.calculate(leftOperand, rightOperand, operator);
                    System.out.println("Result is: " + result);
                // если не проходят под условие от 1 до 10 выбрасываем исключение
                } else {
                    throw new NumberFormatException("Use numbers from 1 to 10");
                }
            // логика калькуляции римских цифр
            } else {
                leftOperand = ConverterForOperands.converterForOperands(symbols[0]);
                rightOperand = ConverterForOperands.converterForOperands(symbols[2]);
                operator = symbols[1];
                int result = Calculator.calculate(leftOperand, rightOperand, operator);
                // проверяем условие использования римских цифр операндов от 'I' до 'X'
                if (leftOperand < 1 || leftOperand > 10 || rightOperand < 1 || rightOperand > 10) {
                    throw new Exception("Use numbers from I to X");
                // проверяем что результат калькуляции римских цифр не менее 'I'
                } else if (result < 1) {
                    throw new ArithmeticException("Roman result is less than 'I'");
                } else {
                    System.out.println("Results is: " + ConverterForResult.converterForResult(result));
                }
            }
        } catch(NumberFormatException e) {
            System.out.println("Please use arabic numbers from '1' to '10'");
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("Invalid expression, result can't be less than 'I'");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Please use only these roman numbers: 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X'");
            System.exit(0);
        }
    }

    // метод для проверки типа типа операндов
    public static boolean isInteger(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}




