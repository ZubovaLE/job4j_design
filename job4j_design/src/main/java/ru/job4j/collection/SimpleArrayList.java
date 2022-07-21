package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements List<T> {
    private final T[] container;
    private int size = 0;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size < container.length) {
            container[size++] = value;
        }
    }

    @Override
    public T set(int index, T newValue) {
        return null;
    }

    @Override
    public T remove(int index) {
        T obj = container[index];
        Objects.checkIndex(index, container.length);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        return obj;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
