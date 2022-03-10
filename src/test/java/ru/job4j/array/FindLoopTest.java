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

    @Test
    @DisplayName("Test the indexOf method when a diapason has an element")
    void testIndexOfWhenDiapasonHas3Then2() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int el = 3;
        int start = 1;
        int finish = 3;
        int out = FindLoop.indexOf(array, el, start, finish);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the indexOf method when a diapason has not an element")
    void testIndexOfWhenDiapasonHasNot15ThenMinus1() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int el = 15;
        int start = 1;
        int finish = 3;
        int out = FindLoop.indexOf(array, el, start, finish);
        int expected = -1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the indexOf method when a diapason hasn't an element, but array has")
    void testIndexOfWhenDiapasonHasNot1ThenMinus1() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int el = 1;
        int start = 1;
        int finish = 3;
        int out = FindLoop.indexOf(array, el, start, finish);
        int expected = -1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the indexOf method when a diapason has elements")
    void testIndexOfWhenDiapasonHasTwo4Then1() {
        int[] array = new int[]{5, 4, 4, 2, 1};
        int el = 4;
        int start = 1;
        int finish = 3;
        int out = FindLoop.indexOf(array, el, start, finish);
        int expected = 1;
        assertEquals(expected, out);
    }
}