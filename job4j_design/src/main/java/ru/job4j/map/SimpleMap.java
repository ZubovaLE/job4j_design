package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = (MapEntry<K, V>[]) new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }
        boolean result = false;
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        } else {
            replace(key, value);
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity = capacity << 1;
        MapEntry<K, V>[] oldTable = table;
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
        count = 0;
        modCount = 0;
        for (MapEntry<K, V> m : oldTable) {
            if (m != null) {
                put(m.key, m.value);
            }
        }
    }

    private void replace(K key, V value) {
        if (key != null) {
            remove(key);
            put(key, value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int index = indexFor(hash(key.hashCode()));
        return table[index] != null ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (key == null) {
            return false;
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            modCount++;
            count--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int point = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int index = point; index < capacity; index++) {
                    if (table[index] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (table[point] == null) {
                    point++;
                    return next();
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
