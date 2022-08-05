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
        assertTrue(map.put(1, "one"));
        assertTrue(map.put(2, "two"));
        assertTrue(map.put(3, "three"));
        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertEquals("three", map.get(3));
    }

    @Test
    @DisplayName("Put when key is null then return false")
    void putWhenKeyIsNullThenReturnFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "one"));
        assertFalse(map.put(null, "two"));

        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Get when invalid key then return null")
    void getWhenInvalidKeyThenReturnNull() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertNull(map.get(55));
    }

    @Test
    @DisplayName("Get when key is null then return null")
    void getWhenKeyIsNullThenReturnNull() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertNull(map.get(null));
    }

    @Test
    @DisplayName("Put when key already exists then false and replace its value")
    void putWhenKeyExistsThenReplace() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "one"));
        assertFalse(map.put(1, "another"));
        assertEquals("another", map.get(1));
    }

    @Test
    @DisplayName("Get elements after expanding")
    void whenExpand() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertEquals("three", map.get(3));
        assertEquals("four", map.get(4));
        assertEquals("five", map.get(5));
        assertEquals("six", map.get(6));
        assertEquals("seven", map.get(7));
        assertEquals("eight", map.get(8));
        assertEquals("nine", map.get(9));
        assertEquals("ten", map.get(10));
        assertEquals("eleven", map.get(11));
        map.put(12, "twelve");
        map.put(13, "thirteen");
        assertEquals("twelve", map.get(12));
        assertEquals("thirteen", map.get(13));
    }

    @Test
    @DisplayName("Check iterator")
    void checkIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Remove when valid key then true and .get returns null")
    void removeWhenValidKeyThenReturnTrue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        assertTrue(map.remove(2));
        assertNull(map.get(2));

        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Remove when key is null then return false")
    void removeWhenKeyIsNullThenReturnFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertFalse(map.remove(null));
    }

    @Test
    @DisplayName("Remove when invalid key then return false")
    void removeWhenInvalidKeyThenReturnFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertFalse(map.remove(null));
    }

    @Test
    @DisplayName("Remove after calling iterator then .next throws ConcurrentModificationException")
    void removeAfterCallingIteratorThenGetException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(map.remove(2));
        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    @DisplayName("Put after calling iterator then.next throws ConcurrentModificationException")
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

    @Test
    @DisplayName("Put after calling iterator then .hasNext throws ConcurrentModificationException")
    void putAfterCallingIteratorThenHasNextThrowsException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(map.put(2, "two"));
        assertThrows(ConcurrentModificationException.class, iterator::hasNext);
    }

    @Test
    @DisplayName("Remove after calling iterator then hasNext throws ConcurrentModificationException")
    void removeAfterCallingIteratorThenHasNextThrowsException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertTrue(map.remove(2));
        assertThrows(ConcurrentModificationException.class, iterator::hasNext);
    }
}