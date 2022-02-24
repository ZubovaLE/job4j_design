package ru.job4j.calculator;

public class Methods {

    public static void addition (int a, int b) {
        int result = a + b;
        System.out.println(String.format("%d + %d = %d", a, b, result));
    }

    public static void subtraction (int a, int b) {
        int result = a-b;
        System.out.println(String.format("%d - %d = %d", a, b, result));
    }

    public static void multiplication (int a, int b) {
        int result = a*b;
        System.out.println(String.format("%d*%d = %d", a, b, result));
    }

    public static void division (int a, int b) {
     int result = a/b;
     System.out.println(String.format("%d/%d = %d", a, b, result));
     }

    public static void main(String[] args){

        int num1 = 100;
        int num2 = 500;
        int num3 = 4;
        int num4 = 2;
        int num5 = 3;
        int num6 = 5;

        Methods.addition(num1, num2);
        Methods.addition(num3, num4);
        Methods.addition(num5, num6);

        Methods.subtraction(num3,num4);
        Methods.multiplication(num5,num6);
        Methods.division(num2,num1);
    }
}
