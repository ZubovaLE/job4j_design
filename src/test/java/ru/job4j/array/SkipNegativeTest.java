package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipNegativeTest {

    @Test
    @DisplayName("Test skip method when array has an equal number of rows and columns")
    public void whenArrayRowAndColumnEquals() {
        int[][] array = {
                {1, -2},
                {1, 2}
        };
        int[][] result = SkipNegative.skip(array);
        int[][] expected = {
                {1, 0},
                {1, 2}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test skip method when array does not have an equal number of rows and columns")
    public void whenArrayRow4AndColumnNotEquals() {
        int[][] array = {
                {1, -2},
                {1, 2, -3},
                {1, -2, 3, -4},
                {1, 2, -3, -4, 5}
        };
        int[][] result = SkipNegative.skip(array);
        int[][] expected = {
                {1, 0},
                {1, 2, 0},
                {1, 0, 3, 0},
                {1, 2, 0, 0, 5}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test skip method when all elements in a row are negative")
    public void whenAllRowIsNegative() {
        int[][] array = {
                {-1, -2, -3},
                {1, 2, 3, -4},
                {1, 2, 3, 4, -5},
                {1, 2, 3, 4, 5, -6},
                {1, 2, 3, 4, 5, 6, -7}
        };
        int[][] out = SkipNegative.skip(array);
        int[][] expected = {
            {0, 0, 0},
            {1, 2, 3, 0},
            {1, 2, 3, 4, 0},
            {1, 2, 3, 4, 5, 0},
            {1, 2, 3, 4, 5, 6, 0}
        };
        assertArrayEquals(expected, out);
    }
}