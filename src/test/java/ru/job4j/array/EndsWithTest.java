package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndsWithTest {

    @Test
    @DisplayName("Test the check method when the ends of the arrays are equal")
    void testCheckWhenTheEndsOfTheArraysAreEqualThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'o'};
        boolean out = EndsWith.check(word, post);
        assertTrue(out);
    }

    @Test
    @DisplayName("Test the check method when the ends of the arrays are not equal")
    void testCheckWhenTheEndsOfTheArraysAreNotEqualThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'a'};
        boolean out = EndsWith.check(word, post);
        assertFalse(out);
    }
}