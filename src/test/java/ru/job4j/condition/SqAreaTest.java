package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqAreaTest {

    @DisplayName("Test method square when p = 6, k = 2, result = 2")
    @Test
    void squareWhenPIs6KIs2Then2() {
        int p = 6;
        double k = 2;
        double expected = 2;
        double out = SqArea.square(p, k);
        double exp = 0.01;
        assertEquals(expected, out, exp);
    }

    @DisplayName("Test method square when p = 8, k = 3, result = 3")
    @Test
    void squareWhenPIs8KIs4Then3() {
        int p = 8;
        double k = 3;
        double expected = 3;
        double out = SqArea.square(p, k);
        double exp = 0.01;
        assertEquals(expected, out, exp);
    }

    @DisplayName("Test method square when p = 20, k = 4, result = 16")
    @Test
    void squareWhenPIs20KIs4Then16() {
        int p = 20;
        double k = 4;
        double expected = 16;
        double out = SqArea.square(p, k);
        double exp = 0.01;
        assertEquals(expected, out, exp);
    }
}