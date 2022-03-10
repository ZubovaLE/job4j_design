package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinTest {

    @Test
    @DisplayName("Test findMin when the first element is min")
    public void whenFirstMin() {
        int[] array = new int[]{0, 5, 10};
        int result = Min.findMin(array);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test findMin when the last element is min")
    public void whenLastMin() {
        int[] array = new int[]{10, 5, 3};
        int result = Min.findMin(array);
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test findMin when the middle element is min")
    public void whenMiddleMin() {
        int[] array = new int[]{10, 2, 5};
        int result = Min.findMin(array);
        int expected = 2;
        assertEquals(expected, result);
    }
}