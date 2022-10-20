package ru.job4j.it;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayItTest {

    @Test
    @DisplayName("Test hasNext")
    void hasNext() {
        ArrayIt it = new ArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    @DisplayName("Test next method")
    void next() {
        ArrayIt it = new ArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(
                new int[]{}
        );
        assertThrows(NoSuchElementException.class, it::next);
    }
}