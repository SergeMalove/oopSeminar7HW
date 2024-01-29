package oopSeminar7HW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorController {
    List<String> log = new ArrayList<>();

    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView) {
        this.calculatorModel = calculatorModel;
        this.calculatorView = calculatorView;
    }

    double getNumber() throws IOException {
        while (true) {
            String s = calculatorView.userInput("Введите число: ");
            if (Pattern.compile("-?\\d+(\\.\\d+)?").matcher(s).matches()) {
                log.add(new Date() + " Введено число: " + s);
                return Double.parseDouble(s);
            } else {
                System.out.println("Неправильный ввод числа!");
                log.add(new Date() + " Неправильный ввод числа: " + s);
            }
        }
    }

    char getSymbol() throws IOException {
        while (true) {
            String c = calculatorView.userInput("Введите действие:\n " +
                    "'+' - сложение\n" + "'-' - разность\n" + "'*' - умножение\n" + "'/' - деление\n" );
            char symb = c.charAt(0);
            if ((c.length() == 1) && (symb == '+' || symb == '-' || symb == '*' || symb == '/')) {
                log.add(new Date() + " Введено действие: " + c);
                return symb;
            } else {
                log.add(new Date() + " Введено неправильное действие: " + c);
                System.out.println("Неправильный ввод действия!");
            }
        }
    }

    public void run() throws IOException {
        System.out.println("Вас приветсвует программа Калькулятор!\n");
        boolean isRun = true;

        while (isRun) {
            System.out.println("Введите 1, чтобы произвести вычисления\n" +
                    "Введите 0, чтобы закрыть программу\n");

            String userImput = calculatorView.userInput("");

            if (!userImput.matches("[0-1]")) {
                System.out.println("Неправильный ввод пункта меню!");
            } else {
                if (Integer.parseInt(userImput) == 0) {
                    isRun = false;
                    System.out.println("До новых встреч!");
                }
                else {
                    calculatorModel.setNum1(getNumber());
                    calculatorModel.setNum2(getNumber());
                    System.out.println();
                    calculatorModel.setSymb(getSymbol());
                    double res = calculatorModel.calculation();
                    System.out.println("\nРезультат вычисления: " + res + "\n");
                    log.add(new Date() + " Результат вычисления: " + res);
                }
            }
        }
    }
}
