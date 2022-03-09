package ru.job4j.array;

public class Check {
    public static boolean mono(boolean[] date) {
        boolean result = true;
        for (boolean event : date) {
            if (event != date[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
