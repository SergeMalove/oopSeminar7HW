package oopSeminar7HW;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorModel, calculatorView);

        calculatorController.run();

        // Код для проверки работы лога
        System.out.println("\nПосмотрим, что записалось в логе:");
        System.out.println(String.join("\n", calculatorController.log));
    }
}
