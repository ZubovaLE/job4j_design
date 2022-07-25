package ru.job4j.iterator;

public interface List<E> extends Iterable<E> {
    void add(E value);

    E get(int index);

}
