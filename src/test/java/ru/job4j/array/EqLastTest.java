package ru.job4j.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqLastTest {

    @Test
    public void whenEqual() {
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {5, 4, 3};
        boolean result = EqLast.check(firstArray, secondArray);
        assertTrue(result);
    }

    @Test
    public void whenNotEqual() {
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {3, 3, 4};
        boolean result = EqLast.check(firstArray, secondArray);
        assertFalse(result);
    }
}