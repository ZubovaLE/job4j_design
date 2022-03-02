package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideBySixTest {

    @Test
    @DisplayName("Test checkResult method when number = 24")
    public void whenNumberDivideBy6() {
        int in = 24;
        String result = DivideBySix.checkNumber(in);
        String expected = "The number is divided by six.";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test checkResult method when number = 9")
    public void whenNumberDivideBy3AndNotEven() {
        int in = 9;
        String result = DivideBySix.checkNumber(in);
        String expected = "The number is divided by 3, but isn't even.";
       assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test checkResult method when number = 14")
    public void whenNumberNoDivideBy3AndEven() {
        int in = 14;
        String result = DivideBySix.checkNumber(in);
        String expected = "The number is even, but isn't divided by three.";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test checkResult method when number = 25")
    public void whenNumberNoDivideBy3AndNotEven() {
        int in = 25;
        String result = DivideBySix.checkNumber(in);
        String expected = "The number isn't even and isn't divided by three.";
       assertEquals(expected, result);
    }
}