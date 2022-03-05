package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @Test
    @DisplayName("Test the calc method when finish = 5, then count = 3")
    void testCalcWhenFinishIs5Then3() {
        int finish = 5;
        int out = PrimeNumber.calc(finish);
        int expected = 3;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when finish = 1, then count = 1")
    void testCalcWhenFinishIs1Then1() {
        int finish = 1;
        int out = PrimeNumber.calc(finish);
        int expected = 0;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when finish = 0, then count = 0")
    void testCalcWhenFinishIs0Then0() {
        int finish = 0;
        int out = PrimeNumber.calc(finish);
        int expected = 0;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when finish = 3, then count = 2")
    void testCalcWhenFinishIs3Then2() {
        int finish = 3;
        int out = PrimeNumber.calc(finish);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when finish = 11, then count = 5")
    void testCalcWhenFinishIs11Then5() {
        int finish = 11;
        int out = PrimeNumber.calc(finish);
        int expected = 5;
        assertEquals(expected, out);
    }
}