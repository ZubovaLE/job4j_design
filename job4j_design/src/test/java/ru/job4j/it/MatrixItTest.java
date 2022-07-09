package ru.job4j.it;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MatrixItTest {

    @Test
    @DisplayName("Test the next method when one element")
    public void when1El() {
        int[][] in = {
                {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test the next method when the first array is empty, but the second is not")
    public void testNextWhenFirstEmpty() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
    }

    @Test
    @DisplayName("Test the hasNext method when the first array is empty, but the second is not, then true")
    public void testHasNextWhenFirstEmptySecondIsNotEmptyThenTrue() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(true));
    }

    @Test
    @DisplayName("Test the next method when rows have different size")
    public void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    @DisplayName("Test the next method when there are a few empty arrays")
    public void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    @DisplayName("Test the hasNext method when there is only one empty array then false")
    public void testHasNextWhenOneEmptyArrayThenFalse() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test the next method when there is only one empty array then exception")
    public void testNextWhenOneEmptyArrayThenException() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    @DisplayName("Test the hasNext method when multiple call then true")
    public void whenMultiHasNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    @DisplayName("Test the hasNext method when there are only empty arrays then false")
    public void whenNoElements() {
        int[][] in = {{}, {}, {}};
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(false));
    }
}