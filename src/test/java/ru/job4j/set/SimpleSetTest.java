package ru.job4j.set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSetTest {
    @Test
    @DisplayName("When add nonNull element then return true and .contains return true. "
            + "When add duplicate of nonNull element then return false")
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    @DisplayName("When add null element then return true and .contains return true. "
            + "When add duplicate of null element then return false")
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    @DisplayName("Test iterator")
    void when() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        Iterator<Integer> iterator = set.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @DisplayName("When get iterator twice then start from the beginning")
    void getIteratorTwiceThenStartFromTheBeginning() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        assertTrue(set.iterator().hasNext());
        assertTrue(set.iterator().hasNext());
        assertEquals(1, set.iterator().next());
        assertEquals(1, set.iterator().next());
    }

    @Test
    @DisplayName("Get iterator when empty set then get NoSuchElementException")
    void whenEmptySetThenNextThrowsNoSuchElementException() {
        Set<Integer> set = new SimpleSet<>();
        assertFalse(set.iterator().hasNext());
        assertThrows(NoSuchElementException.class, set.iterator()::next);
    }

    @Test
    @DisplayName("Contains when invalid value then false")
    void containsWhenInvalidValueThenFalse() {
        Set<Integer> set = new SimpleSet<>();
        assertFalse(set.contains(1));
    }

}