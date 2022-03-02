package ru.job4j.condition;

public class Triangle {
    public static boolean exist(double ab, double bc, double ac) {
        return checkLine(ab, bc, ac) && checkLine(ab, ac, bc) && checkLine(bc, ac, ab);
    }

    private static boolean checkLine(double lineOne, double lineTwo, double lineThree) {
        return lineOne + lineTwo > lineThree;
    }
}