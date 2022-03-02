package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("Test exist method when ab = 3, ac = 4, bc = 5 then result is true")
    void whenExist() {
        double ab = 3;
        double ac = 4;
        double bc = 5;
        boolean out = Triangle.exist(ab, ac, bc);
        assertTrue(out);
    }

    @Test
    @DisplayName("Test exist method when ab = 1, ac = 1, bc = 1 then result is false")
    void existWhenNotExist() {
        double ab = 1;
        double ac = 3;
        double bc = 1;
        boolean out = Triangle.exist(ab, ac, bc);
        assertFalse(out);
    }
}