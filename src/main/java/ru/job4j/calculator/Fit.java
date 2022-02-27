package ru.job4j.calculator;

public class Fit {

    public static double manWeight(short height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(short height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {

        double man = Fit.manWeight((short) 187);
        double woman = Fit.womanWeight((short) 165);
        System.out.println("man's ideal weight is " + man + " and woman's ideal weight is " + woman);
    }
}

