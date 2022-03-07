package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("Test the calculate method when bound = 3, then int[]{0, 1, 4}")
    void testCalculateWhenBoundIs3Then014() {
        int bound = 3;
        int[] out = Square.calculate(bound);
        int[] expected = new int[]{0, 1, 4};
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calculate method when bound = 5, then int[]{0, 1, 4, 9, 16}")
    void testCalculateWhenBoundIs5() {
        int bound = 5;
        int[] out = Square.calculate(bound);
        int[] expected = new int[]{0, 1, 4, 9, 16};
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calculate method when bound = 1, then int[]{0}")
    void testCalculateWhenBoundIs1() {
        int bound = 1;
        int[] out = Square.calculate(bound);
        int[] expected = new int[]{0};
        assertArrayEquals(expected, out);
    }
}