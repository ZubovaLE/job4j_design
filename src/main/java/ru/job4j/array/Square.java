package ru.job4j.array;

public class Square {
    public static int[] calculate(int bound) {
        int[] elements = new int[bound];
        for (int i = 0; i < bound; i++) {
            elements[i] = i * i;
        }
        return elements;
    }

    public static void main(String[] args) {
        int[] array = calculate(5);
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("elements[%d]: ", i) + array[i]);
        }
    }
}
