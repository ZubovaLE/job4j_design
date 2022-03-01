package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    @DisplayName("Test the method 'findMax' when first = 0, second = 65, result = 65")
    void findMaxWhen0And65Then65() {
        int first = 0;
        int second = 65;
        int out = Max.findMax(first, second);
        int expected = 65;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'findMax' when first = 34, second = -35, result = 34")
    void findMaxWhen34AndMinus35Then34() {
        int first = 34;
        int second = -35;
        int out = Max.findMax(first, second);
        int expected = 34;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'findMax' when first = 5, second = 5, result = 5")
    void findMaxWhen5And5Then5() {
        int first = 5;
        int second = 5;
        int out = Max.findMax(first, second);
        int expected = 5;
        assertEquals(expected, out);
    }
}