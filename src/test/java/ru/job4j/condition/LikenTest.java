package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikenTest {

    @Test
    @DisplayName("Test method compareGreaterOrNo when first = 10, second = 5, result = true")
    void compareGreaterOrNoWhen10And5ThenTrue() {
        int first = 10;
        int second = 5;
        boolean expected = true;
        boolean out = Liken.compareGreaterOrNo(first, second);
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test method compareLessrOrNo when first = 7, second = 3, result = false")
    void compareLessOrNoWhen7And3ThenFalse() {
        int first = 7;
        int second = 3;
        boolean expected = false;
        boolean out = Liken.compareLessOrNo(first, second);
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test method compareEqualOrNo when first = 0, second = 0, result = true")
    void compareEqualOrNoWhen0And0ThenTrue() {
        int first = 0;
        int second = 0;
        boolean expected = true;
        boolean out = Liken.compareEqualOrNo(first, second);
        assertEquals(expected, out);
    }
}