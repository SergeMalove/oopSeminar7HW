package oopSeminar7HW;

public interface Multyplication {
    default double multiply(double a, double b) {
        return a * b;
    }
}
