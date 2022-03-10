package ru.job4j.array;

public class FindLoop {
    public static int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public static int indexOf(int[] data, int el, int start, int finish) {
    //data - массив чисел
    //el - элемент, который нужно найти,
    //start - индекс, с которого начинаем поиск,
    //finish - индекс, которым заканчиваем поиск.
        int result = -1;
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
