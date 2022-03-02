package ru.job4j.condition;

public class PointEq {
    public static boolean areEqual(int x1, int x2, int y1, int y2) {
        return (x1 == x2 && y1 == y2);
    }

    public static void main(String[] args) {
        System.out.println("Are the points equal? - " + areEqual(1, 1, 1, 1));
        System.out.println("Are the points equal? - " + areEqual(3, 4, 5, 3));
    }
}
