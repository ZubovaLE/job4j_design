package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    @Test
    @DisplayName("Test the back method when the array has even number of elements")
    void testBackWhenEvenNumberOfElements() {
        int[] array = new int[] {5, 3, 1, 4};
        int[] out = Turn.back(array);
        int[] expected = new int[] {4, 1, 3, 5};
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test the back method when the array has odd number of elements")
    void testBackWhenOddNumberOfElements() {
        int[] array = new int[] {6, 5, 4, 3, 2};
        int[] out = Turn.back(array);
        int[] expected = new int[] {2, 3, 4, 5, 6};
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test the back method for 0 to 10")
    void testBackFor0To10() {
        int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] out = Turn.back(array);
        int[] expected = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        assertArrayEquals(expected, out);
    }

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = Turn.back(input);
        int[] expected = new int[] {2, 6, 1, 4};
        assertArrayEquals(expected, result);
    }
}