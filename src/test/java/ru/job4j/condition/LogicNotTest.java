package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicNotTest {

    @Test
    @DisplayName("Test the method 'isEven' when num = 8 and result = true")
    void isEvenWhen8ThenTrue() {
        int in = 8;
        boolean out = LogicNot.isEven(in);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'isEven' when num = 8 and result = true")
    void isEvenWhen3ThenFalse() {
        int in = 3;
        boolean out = LogicNot.isEven(in);
        boolean expected = false;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'isPositive' when num = 56 and result = true")
    void isPositiveWhen56ThenTrue() {
        int in = 56;
        boolean out = LogicNot.isPositive(in);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'isNotEven' when num = 43 and result = true")
    void isNotEvenWhen43ThenTrue() {
        int in = 43;
        boolean out = LogicNot.isNotEven(in);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'isNotEven' when num = 10 and result = false")
    void isNotEvenWhen10ThenFalse() {
        int in = 10;
        boolean out = LogicNot.isNotEven(in);
        boolean expected = true;
        assertNotEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'notPositive' when num = -5 and result = true")
    void notPositiveWhenMinus5ThenTrue() {
        int in = -5;
        boolean out = LogicNot.notPositive(in);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'notEvenAndPositive when num = and result = ")
    void notEvenAndPositiveWhen43ThenTrue() {
        int in = 43;
        boolean out = LogicNot.notEvenAndPositive(in);
        boolean expected = true;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'notEvenAndPositive when num = -10 and result = true ")
    void evenOrNotPositiveWhenMinus10() {
        int in = -10;
        boolean out = LogicNot.evenOrNotPositive(in);
        boolean expected = true;
        assertEquals(expected, out);
    }
}