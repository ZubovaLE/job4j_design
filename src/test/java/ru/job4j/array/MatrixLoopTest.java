package ru.job4j.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixLoopTest {

    @Test
    public void whenSingle() {
        int[][] array = {
                {10}
        };
        int result = MatrixLoop.sum(array);
        int expected = 10;
        assertEquals(expected, result);
    }

    @Test
    public void whenTwo() {
        int[][] array = {
                {1, 2},
                {1, 2}
        };
        int result = MatrixLoop.sum(array);
        int expected = 6;
        assertEquals(expected, result);
    }

    @Test
    public void whenThree() {
        int[][] array = {
                {1, 2, 1},
                {1, 2, 0}
        };
        int result = MatrixLoop.sum(array);
        int expected = 7;
        assertEquals(expected, result);
    }
}