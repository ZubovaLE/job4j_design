package ru.job4j.calculator;

public class Calculator {

    public static void plus (int a, int b) {
        int result = a + b;
        System.out.println(String.format("%d + %d = %d", a, b, result));
    }

    public static void main(String[] args){
        int one = 1;
        int two = 2;
        int six = 6;
        int four = 4;
        int five = 5;

        Calculator.plus(one,two);

        int sixDivTwo = six/two;
        int fiveMinusTwo = five - two;
        int fourTimeTwo = four*two;

        System.out.println("6/2 = " +sixDivTwo);
        System.out.println("5 - 2 = " + fiveMinusTwo);
        System.out.print("4 * 2 = " + fourTimeTwo);
    }
}
