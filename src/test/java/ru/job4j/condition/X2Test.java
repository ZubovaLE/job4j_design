package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class X2Test {

    @DisplayName("Test method Calc. When a = 1, b = 1, c = 1, x = 1. Result = 3.")
    @Test
    void textCalcWnenAIsOneBIsOneCIsOneXIsOneShouldThree() {
        int a = 1;
        int b = 1;
        int c = 1;
        int x = 1;

        int expected = 3;
        int out = X2.calc(a, b, c, x);
        assertEquals(expected, out);
    }

    @DisplayName("Test method Calc. When a = 0, b = 1, c = 1, x = 1. Result = 2.")
    @Test
    void textCalcWnenAIsZeroBIsOneCIsOneXIsOneShouldTwo() {
        int a = 0;
        int b = 1;
        int c = 1;
        int x = 1;

        int expected = 2;
        int out = X2.calc(a, b, c, x);
        assertEquals(expected, out);
    }

    @DisplayName("Test method Calc. When a = 1, b = 1, c = 0, x = 1. Result = 2.")
    @Test
    void textCalcWnenAIsOneBIsOneCIsZeroXIsOneShouldTwo() {
        int a = 0;
        int b = 1;
        int c = 1;
        int x = 1;

        int expected = 2;
        int out = X2.calc(a, b, c, x);
        assertEquals(expected, out);
    }

    @DisplayName("Test method Calc. When a = 1, b = 1, c = 1, x = 0. Result = 1.")
    @Test
    void textCalcWnenAIsOneBIsOneCIsOneXIsZeroShouldOne() {
        int a = 1;
        int b = 1;
        int c = 1;
        int x = 0;

        int expected = 1;
        int out = X2.calc(a, b, c, x);
        assertEquals(expected, out);
    }
}