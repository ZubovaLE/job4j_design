package ru.job4j.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMapTest {

    @Test
    @DisplayName("When put then get")
    void whenPutThenGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(map.get(1), "one");
        assertEquals(map.get(2), "two");
        assertEquals(map.get(3), "three");
        assertNull(map.get(55));
    }

    @Test
    @DisplayName("Check iterator")
    void checkIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 1);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 2);
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Test remove")
    void testRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        assertTrue(map.remove(2));
        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 1);
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Remove after calling iterator then get ConcurrentModificationException")
    void removeAfterCallingIteratorThenGetException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(map.remove(2));
        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    @DisplayName("Put after calling iterator then get ConcurrentModificationException")
    void putAfterCallingIteratorThenGetException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(map.put(2, "two"));
        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    @DisplayName("Call .next when empty map then get NoSuchElementException")
    void callNextWhenEmptyMapThenGetException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> iterator = map.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}