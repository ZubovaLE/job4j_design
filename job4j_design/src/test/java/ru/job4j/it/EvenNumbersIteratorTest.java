package ru.job4j.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class EvenNumbersIteratorTest {

    private Iterator<Integer> it;

    @BeforeEach
    public void setUp() {
        it = new EvenNumbersIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    @DisplayName("When array has both even and odd numbers then return even numbers sequentially")
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    @DisplayName("Check that sequential HasNext invocation does not affect retrieval order")
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test hasNext method when no even numbers then false")
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenNumbersIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }

    @Test
    @DisplayName("When all elements are even numbers")
    public void allNumbersAreEven() {
        it = new EvenNumbersIterator(new int[]{2, 4, 6});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }
}