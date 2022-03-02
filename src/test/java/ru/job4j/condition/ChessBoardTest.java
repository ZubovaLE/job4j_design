package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    @DisplayName("Test way method when x1 = 6, y1 = 7, x2 = 1, y2 = 2 then result is 5")
    public void wayIs5() {
        int x1 = 6;
        int y1 = 7;
        int x2 = 1;
        int y2 = 2;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 5;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x1 = 7, y1 = 0, x2 = 0, y2 = 7 then result is 7")
    public void wayIs7() {
        int x1 = 7;
        int y1 = 0;
        int x2 = 0;
        int y2 = 7;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 7;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x1 = 2, y1 = 6, x2 = 4, y2 = 1 then result is 0")
    public void wayIs0() {
        int x1 = 2;
        int y1 = 6;
        int x2 = 4;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x1 < 0 then result is 0")
    public void whenX1isMinus1ThenWayIs0() {
        int x1 = -1;
        int y1 = 6;
        int x2 = 4;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when y1 < 0 then result is 0")
    public void whenY1isMinus1ThenWayIs0() {
        int x1 = 2;
        int y1 = -1;
        int x2 = 4;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x2 < 0 then result is 0")
    public void whenX2isMinus1ThenWayIs0() {
        int x1 = 2;
        int y1 = 6;
        int x2 = -1;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when y2 < 0 then result is 0")
    public void whenY2isMinus1ThenWayIs0() {
        int x1 = 2;
        int y1 = 6;
        int x2 = 4;
        int y2 = -1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x1 > 7 then result is 0")
    public void whenX1isGreater7ThenWayIs0() {
        int x1 = 10;
        int y1 = 6;
        int x2 = 4;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when y1 > 7 then result is 0")
    public void whenY1isGreater7ThenWayIs0() {
        int x1 = 2;
        int y1 = 10;
        int x2 = 4;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when x2 > 7 then result is 0")
    public void whenX2isGreater7ThenWayIs0() {
        int x1 = 2;
        int y1 = 6;
        int x2 = 10;
        int y2 = 1;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test way method when y2 > 7 then result is 0")
    public void whenY2isGreater7ThenWayIs0() {
        int x1 = 2;
        int y1 = 6;
        int x2 = 4;
        int y2 = 10;
        int result = ChessBoard.way(x1, y1, x2, y2);
        int expected = 0;
        assertEquals(expected, result);
    }
}