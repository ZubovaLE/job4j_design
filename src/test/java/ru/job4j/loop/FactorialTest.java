package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    @DisplayName("Test the calc method when n = 0, then factorial = 1")
    void testCalcWhenNIs0ThenFactorialIs1() {
        int n = 0;
        int out = Factorial.calc(n);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when n = 5, then factorial = 120")
    void testCalcWhenNIs5ThenFactorialIs120() {
        int n = 5;
        int out = Factorial.calc(n);
        int expected = 120;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when n = 1, then factorial = 1")
    void testCalcWhenNIs1ThenFactorialIs1() {
        int n = 1;
        int out = Factorial.calc(n);
        int expected = 1;
        assertEquals(expected, out);
    }
}