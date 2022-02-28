package ru.job4j.condition;

public class Liken {

    public static boolean compareGreaterOrNo(int first, int second) {
        return first > second;
    }

    public static boolean compareLessOrNo(int first, int second) {
        return first < second;
    }

    public static boolean compareEqualOrNo(int first, int second) {
        return first == second;
    }

    public static void main(String[] args) {
        int first = 10;
        int second = 9;

        System.out.println(compareGreaterOrNo(first, second));
        System.out.println(compareLessOrNo(first, second));
        System.out.println(compareEqualOrNo(first, second));
    }
}
