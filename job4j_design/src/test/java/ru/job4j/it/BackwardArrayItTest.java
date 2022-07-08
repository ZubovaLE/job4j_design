package ru.job4j.it;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class BackwardArrayItTest {

    @Test
    @DisplayName("Test hasNext method when not empty array then true")
    public void whenCallHasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
    }

    @Test
    @DisplayName("Test hasNext method when empty array then false")
    public void whenCallHasNextWhenEmptyArrayThenFalse() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        assertThat(it.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test the next method when read the sequence in array")
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    @DisplayName("Test the next method when empty array then NoSuchElementException exception")
    public void whenNextFromEmptyThenException() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        assertThrows(NoSuchElementException.class, it::next);
    }
}