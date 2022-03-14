package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCheckTest {

    /**
     * Tests for isMonoHorizontal method
     */
    @Test
    @DisplayName("Test isMonoHorizontal when row of an array is full of X")
    void testWhenHasMonoHorizontalRow() {
        char[][] input = {
                {' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', ' '}
        };
        int row = 1;
        boolean result = MatrixCheck.isMonoHorizontal(input, row);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test isMonoHorizontal when selected row is not full of X")
    void testWhenTheSelectedRowIsNotFullOfX() {
        char[][] input = {
                {' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', ' '}
        };
        int row = 0;
        boolean result = MatrixCheck.isMonoHorizontal(input, row);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test isMonoHorizontal when row of an array is not full of X")
    void testWhenDoesNotHaveMonoHorizontalRow() {
        char[][] input = {
                {' ', ' ', ' '},
                {'X', 's', 'X', 'X', 'X'},
                {' ', ' ', ' '}
        };
        int row = 1;
        boolean result = MatrixCheck.isMonoHorizontal(input, row);
        assertFalse(result);
    }

    /**
     * /Tests for isMonoVertical method
     */
    @Test
    @DisplayName("Test isMonoVertical when cell of an array is full of X")
    void testWhenIsMonoVertical() {
        char[][] input = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        };
        int column = 0;
        boolean result = MatrixCheck.isMonoVertical(input, column);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test isMonoVertical when selected cell is not full of X")
    void testWhenSelectedCellNotFullOfX() {
        char[][] input = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        };
        int column = 2;
        boolean result = MatrixCheck.isMonoVertical(input, column);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test isMonoVertical when cell of an array is not full of X")
    void testWhenIsNotMonoVertical() {
        char[][] input = {
                {'X', ' ', ' '},
                {'h', ' ', ' '},
                {'h', ' ', ' '}
        };
        int column = 0;
        boolean result = MatrixCheck.isMonoVertical(input, column);
        assertFalse(result);
    }

    /**
     * Tests for extractDiagonal method
     */
    @Test
    @DisplayName("Test extractDiagonal when diagonal is full of X")
    void testExtractDiagonalWhenDiagonalFullX() {
        char[][] input = {
                {'X', ' ', ' '},
                {'h', 'X', ' '},
                {'h', ' ', 'X'},
        };
        char[] out = MatrixCheck.extractDiagonal(input);
        char[] expected = {'X', 'X', 'X'};
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test extractDiagonal when diagonal is full of 1")
    void testExtractDiagonalWhenDiagonalFullOne() {
        char[][] input = {
                {'1', ' ', ' '},
                {'h', '1', ' '},
                {'h', ' ', '1'},
        };
        char[] out = MatrixCheck.extractDiagonal(input);
        char[] expected = {'1', '1', '1'};
        assertArrayEquals(expected, out);
    }

    /**
     * Tests for isWin method
     */
    @Test
    @DisplayName("Test isWin method when the third cell is full of X")
    public void whenDataIsMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test isWin method when no one row is full of X")
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test isWin method when the third row is full of X")
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test isWin method when two rows are full of X")
    public void whenTwoRowsFullOfX() {
        char[][] input = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertTrue(result);
    }
}