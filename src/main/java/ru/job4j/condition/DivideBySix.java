package ru.job4j.condition;

public class DivideBySix {
    public static String checkNumber(int number) {
        String result;
        if (number % 3 == 0 && number % 2 == 0) {
            result = "The number is divided by six.";
        } else if (number % 3 == 0) {
            result = "The number is divided by 3, but isn't even.";
        } else if (number % 2 == 0) {
            result = "The number is even, but isn't divided by three.";
        } else {
            result = "The number isn't even and isn't divided by three.";
        }
        return result;
    }
}
