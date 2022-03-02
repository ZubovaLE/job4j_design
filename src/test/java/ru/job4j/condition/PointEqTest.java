package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointEqTest {

    @Test
    @DisplayName("Test the method 'areEqual' when x1 = 0, x2 = 0, y1 = 0, y2 = 0, result is true")
    void areEqualWhenX1Is0X2Is0Y3Is0Y4Is0ThenTrue() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        boolean out = PointEq.areEqual(x1, x2, y1, y2);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'areEqual' when x1 = 1, x2 = 2, y1 = 3, y2 = 4, result is false")
    void areEqualWhenX1Is1X2Is2Y3Is3Y4Is4ThenFalse() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        boolean out = PointEq.areEqual(x1, x2, y1, y2);
        boolean expected = false;
        assertEquals(expected, out);
    }
}