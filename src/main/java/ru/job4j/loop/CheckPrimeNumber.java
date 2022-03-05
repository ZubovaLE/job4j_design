package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int number) {
        boolean prime = true;
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    prime = false;
                    System.out.printf("The number %d isn't prime%n", number);
                    break;
                }
            }
        } else {
            prime = false;
        }
        return prime;
    }
}
