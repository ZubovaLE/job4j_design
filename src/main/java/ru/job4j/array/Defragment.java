package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != null) {
                        array[i] = array[j];
                        array[j] = null;
                        break;
                    }
                }
            }
        }
        return array;
    }

    public static String[] compressNew(String[] array) {
        String[] result = new String[array.length];
        int step = 0;
        for (String s : array) {
            if (s != null) {
                result[step++] = s;
            }
        }
        return result;
    }
}
