package ru.job4j.condition;

public class Cinema {
    public static void main(String[] args) {
        access(15);
        access(18);
    }

    public static void access(int age) {
        System.out.println("The age of the customer is " + age);

        if (age >= 18) {
            System.out.println("Welcome to the cinema!\n");
        } else {
            System.out.println("Sorry, you are too young\n");
        }
    }
}
