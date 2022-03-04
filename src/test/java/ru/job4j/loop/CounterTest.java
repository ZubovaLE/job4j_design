package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    @DisplayName("Test the sum method when start = 0, finish = 5, then sum = 15")
    void sumWhenStartIs0AndFinishIs5Then15() {
        int start = 0;
        int finish = 5;
        int out = Counter.sum(start, finish);
        int expected = 15;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the sum method when start = 0, finish = 0, then sum = 0")
    void sumWhenStartIs0AndFinishIs0Then0() {
        int start = 0;
        int finish = 0;
        int out = Counter.sum(start, finish);
        int expected = 0;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the sum method when start = -1, finish = 1, then sum = 0")
    void sumWhenStartIsMinus1AndFinishIs1Then() {
        int start = -1;
        int finish = 1;
        int out = Counter.sum(start, finish);
        int expected = 0;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the sum method when start = -5, finish = 0, then sum = -15")
    void sumWhenStartIsMinus5AndFinishIs0Then15() {
        int start = -5;
        int finish = 0;
        int out = Counter.sum(start, finish);
        int expected = -15;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the sum method when start = -1, finish = 4, then sum = 9")
    void sumWhenStartIsMinus1AndFinishIs4Then9() {
        int start = -1;
        int finish = 4;
        int out = Counter.sum(start, finish);
        int expected = 9;
        assertEquals(expected, out);
    }
}