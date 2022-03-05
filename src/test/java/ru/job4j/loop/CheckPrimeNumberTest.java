package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPrimeNumberTest {

    @Test
    @DisplayName("Test the check method when prime number 3")
    void testCheckWhenNumberIs3() {
        int in = 3;
        boolean out = CheckPrimeNumber.check(in);
        assertTrue(out);
    }

    @Test
    @DisplayName("Test the check method when not prime number 4")
    void testCheckWhenNumberIs4() {
        int in = 4;
        boolean out = CheckPrimeNumber.check(in);
        assertFalse(out);
    }

    @Test
    @DisplayName("Test the check method when prime number 1")
    void testCheckWhenNumberIs1() {
        int in = 1;
        boolean out = CheckPrimeNumber.check(in);
        assertFalse(out);
    }
}