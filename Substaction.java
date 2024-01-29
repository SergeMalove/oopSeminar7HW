package oopSeminar7HW;

public interface Substaction {
    default double substract(double a, double b){
        return a - b;
    }
}
