package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*; //подключили пакет полностью

public class MathCalculator {
    public static double addAndMultiple(double first, double second) {
        return add(first, second) + multiply(first, second);
    }

    public static double subAndDiv(double first, double second) {
        return subtract(first, second) + divide(first, second);
    }

    public static double sumOfAllMethods(double first, double second) {
        return add(first, second) + multiply(first, second) + subtract(first, second) + divide(first, second);
    }

    public static void main(String[] args) {
        System.out.println("The result of addition and multiplication is " + addAndMultiple(10, 20));
        System.out.println("The result of subtraction and division is " + subAndDiv(10, 20));
        System.out.println("The result all methods is " + sumOfAllMethods(10, 20));
    }
}
