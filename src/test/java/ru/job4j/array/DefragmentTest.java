package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefragmentTest {

    @Test
    @DisplayName("Test compress method when single first element is null")
    public void testCompressWhenSingleFirstNull() {
        String[] input = {null, "I"};
        String[] result = Defragment.compressNew(input);
        String[] expected = {"I", null};
        assertArrayEquals(expected, result);

        result = Defragment.compress(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test compress method when two elements are null")
    void testCompressWhenTwoNull() {
        String[] input = {"H", null, "e", null, "l", "l", "o"};
        String[] out = Defragment.compressNew(input);
        String[] expected = {"H", "e", "l", "l", "o", null, null};
        assertArrayEquals(expected, out);

        out = Defragment.compress(input);
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test compress method when the first element is null")
    void testCompressWhenFirstNull() {
        String[] input = {null, "G", "o", "o", "d"};
        String[] out = Defragment.compressNew(input);
        String[] expected = {"G", "o", "o", "d", null};
        assertArrayEquals(expected, out);

        out = Defragment.compress(input);
        assertArrayEquals(expected, out);
    }

    @Test
    @DisplayName("Test compress method when all elements are null")
    public void testCompressWhenAllNull() {
        String[] input = {null, null, null};
        String[] result = Defragment.compressNew(input);
        String[] expected = {null, null, null};
        assertArrayEquals(expected, result);

        result = Defragment.compress(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test compress method when three first elements are null")
    public void testCompressWhenFirstElementsNull() {
        String[] input = {null, null, null, "I", "wanna", "be", "compressed"};
        String[] result = Defragment.compressNew(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertArrayEquals(expected, result);

        result = Defragment.compress(input);
        assertArrayEquals(expected, result);
    }
}