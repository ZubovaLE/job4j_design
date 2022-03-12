package ru.job4j.array;

public class LengthArrayArrays {
    public static void main(String[] args) {
        int[][] array = {{1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        for (int[] ints : array) {
            System.out.println("Размер вложенного массива равен: " + ints.length);
        }
    }
}
