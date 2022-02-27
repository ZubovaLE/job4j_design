package ru.job4j.condition;

public class SqArea {

    public static double square(int p, double k) {
        double h = p / (2 * (k + 1));
        double l = h * k;
        return l * h;
    }

    public static void main(String[] args) {
        double result = SqArea.square(6, 2);
        System.out.println("When p = 6 and k = 2, the square equals " + result + " metres");
    }
}
