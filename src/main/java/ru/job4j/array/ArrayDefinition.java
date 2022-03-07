package ru.job4j.array;

public class ArrayDefinition {
    public static void main(String[] args) {
        short[] ages = new short[10];
        String[] surnames = new String[100500];
        float[] prices = new float[40];
        System.out.println("Размер массива ages: " + ages.length + " элементов");
        System.out.println("Размер массива surnames: " + surnames.length + " элементов");
        System.out.println("Размер массива prices: " + prices.length + " элементов");

        String[] names = new String[4];
        names[0] = "Alex";
        names[1] = "Bryan";
        names[2] = "John";
        names[3] = "Scott";
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
