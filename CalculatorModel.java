package oopSeminar7HW;

public class CalculatorModel implements Summary, Substaction, Multyplication, Deviding {
    private double num1;
    private double num2;
    private char symb;


    public CalculatorModel(int num1, int num2, char symb) {
        this.num1 = num1;
        this.num2 = num2;
        this.symb = symb;
    }

    public CalculatorModel() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public char getSymb() {
        return symb;
    }

    public void setSymb(char symb) {
        this.symb = symb;
    }

    public double calculation() {
        return switch (symb) {
            case '+' -> summ(num1, num2);
            case '-' -> devide(num1, num2);
            case '*' -> multiply(num1, num2);
            case '/' -> devide(num1, num2);
            default -> -1;
        };
    }
}
