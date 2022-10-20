package ru.job4j.list.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {
    private static <T> void add(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
        iterator.add(value);
    }

    public static <T> void addBefore(List<T> list, int index, T value) {
        add(list, index, value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        if (index != list.size() - 1) {
            add(list, index + 1, value);
        } else {
            ListIterator<T> iterator = list.listIterator(index);
            iterator.next();
            iterator.add(value);
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        Objects.requireNonNull(filter);
        list.removeIf(filter);
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        Objects.requireNonNull(filter);
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        Objects.requireNonNull(elements);
        for (T x : elements) {
            list.remove(x);
        }
    }
}

