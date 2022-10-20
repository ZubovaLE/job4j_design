package ru.job4j.iterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> lastEl = last;
        Node<E> newNode = new Node<>(lastEl, value, null);
        last = newNode;
        if (size == 0) {
            first = newNode;
        } else {
            lastEl.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> el;
        if (index <= size / 2) {
            el = first;
            for (int i = 0; i < index; i++) {
                el = el.next;
            }
        } else {
            el = last;
            for (int i = size - 1; i > index; i--) {
                el = el.prev;
            }
        }
        return el.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> pointer = first;
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E value = pointer.item;
                pointer = pointer.next;
                point++;
                return value;
            }
        };
    }
}
