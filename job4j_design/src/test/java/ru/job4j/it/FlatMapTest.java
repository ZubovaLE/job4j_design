package ru.job4j.it;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FlatMapTest {

    @Test
    @DisplayName("When three elements in two iterators then return elements sequentially" +
            " and then check that the hasNext method returns false")
    public void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
        assertThat(flat.hasNext(), is(false));
    }

    @Test
    @DisplayName("When three elements in one iterator then return elements sequentially" +
            " and then check that the hasNext method returns false")
    public void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
        assertThat(flat.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test the hasNext method when its multiple call")
    public void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.hasNext(), is(true));
        assertThat(flat.hasNext(), is(true));
    }

    @Test
    @DisplayName("Check that the hasNext method returns false")
    public void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.hasNext(), is(false));
    }

    @Test
    @DisplayName("Test the .next method when empty iterator then exception")
    public void whenEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(data);
        assertThrows(NoSuchElementException.class, flat::next);
    }

    @Test
    @DisplayName("When several empty and not empty iterators then return elements sequentially")
    public void whenSeveralEmptyAndNotEmpty() {
        Iterator<Iterator<?>> it = List.of(
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                List.of(1).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(it);
        assertTrue(flat.hasNext());
        assertThat(1, is(flat.next()));
    }

    @Test
    @DisplayName("Test the .hasNext method when only empty iterators then false")
    public void whenSeveralEmptyThenReturnFalse() {
        Iterator<Iterator<Object>> it = List.of(
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(it);
        assertFalse(flat.hasNext());
    }
}