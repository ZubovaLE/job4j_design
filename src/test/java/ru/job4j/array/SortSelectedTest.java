package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortSelectedTest {

    @Test
    @DisplayName("Test the sort method when int[] {3, 4, 1, 2, 5}")
    public void whenSortArrayOf5Elements() {
        int[] data = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test the sort method when int[] {3, 4, 1, 2, 5, 6}")
    public void whenSortArrayOf6Elements() {
        int[] data = new int[] {3, 4, 1, 2, 5, 6};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test the sort method when int[] {4, 1}")
    public void whenSortArrayOf2Elements() {
        int[] data = new int[] {4, 1};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[] {1, 4};
        assertArrayEquals(expected, result);
    }
}