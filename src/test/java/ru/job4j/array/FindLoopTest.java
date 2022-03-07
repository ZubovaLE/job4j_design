package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLoopTest {

    @Test
    @DisplayName("Test the indexOf method when element is found")
    void testIndexOfWhenElementIsFound() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int el = 3;
        int out = FindLoop.indexOf(array, el);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the indexOf method when element is not found")
    void testIndexOfWhenElementIsNotFound() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int el = 15;
        int out = FindLoop.indexOf(array, el);
        int expected = -1;
        assertEquals(expected, out);
    }
}