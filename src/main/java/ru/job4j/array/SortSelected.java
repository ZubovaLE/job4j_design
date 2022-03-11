package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        //data - массив чисел, который нужно отсортировать по возрастанию.
        for (int i = 0; i < data.length / 2; i++) {
            int min = MinDiapason.findMin(data, i, data.length - 1);
            int index = FindLoop.indexOf(data, min);
            SwitchArray.swap(data, i, index);
        }
        return data;
    }
}
