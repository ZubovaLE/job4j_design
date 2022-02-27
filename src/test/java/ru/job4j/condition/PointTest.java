package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 2, y2 =0")
    @Test
    void distanceWhenX1Is0Y1Is0X2Is2Y2Is0() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        double expected = 2;
        double out = Point.distance(x1, y1, x2, y2);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 0, y2 = 2")
    @Test
    void distanceWhenX1Is0Y1Is0X2Is0Y2Is2() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 2;
        double expected = 2;
        double out = Point.distance(x1, y1, x2, y2);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 0, y2 = 0")
    @Test
    void distanceWhenX1Is0Y1Is0X2Is0Y2Is0() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        double expected = 0;
        double out = Point.distance(x1, y1, x2, y2);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }
}