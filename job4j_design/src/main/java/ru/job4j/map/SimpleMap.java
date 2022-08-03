package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        boolean result = false;
        if (key != null) {
            table[indexFor(hash(key.hashCode()))] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        int h = ((Integer) hashCode).hashCode();
        return h ^ h >>> capacity;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity = capacity << 1;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> m : table) {
            newTable[indexFor(hash(m.key.hashCode()))] = m;
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        if (key != null && table[indexFor(hash(key.hashCode()))] != null) {
                return table[indexFor(hash(key.hashCode()))].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (table[indexFor(hash(key.hashCode()))] != null) {
            table[indexFor(hash(key.hashCode()))] = null;
            result = true;
            modCount++;
            count--;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int point = 1;

            @Override
            public boolean hasNext() {
                return point <= count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[point++].key;
            }
        };
    }

    public static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
