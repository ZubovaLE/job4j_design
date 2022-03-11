package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchArrayTest {

    @Test
    @DisplayName("Test swap method when 0 to 2")
    public void whenSwap0to3() {
        int[] input = {1, 2, 3, 4};
        int source = 0;
        int dest = 2;
        int[] result = SwitchArray.swap(input, source, dest);
        int[] expected = {3, 2, 1, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test swap method when 1 to 2")
    public void whenSwap1to2() {
        int[] input = {1, 2, 3, 4};
        int source = 1;
        int dest = 2;
        int[] result = SwitchArray.swap(input, source, dest);
        int[] expected = {1, 3, 2, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test swapBorder method")
    public void testSwapBorder() {
        int[] input = {1, 2, 3, 4};
        int[] result = SwitchArray.swapBorder(input);
        int[] expected = {4, 2, 3, 1};
        assertArrayEquals(expected, result);
    }
}