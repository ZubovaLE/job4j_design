package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int sizeOfIn;
    private int sizeOfOut;

    public T pop() throws NoSuchElementException {
        if (sizeOfOut == 0) {
            while (sizeOfIn > 0) {
                out.push(in.pop());
                sizeOfIn--;
                sizeOfOut++;
            }
        }
        sizeOfOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        sizeOfIn++;
    }
}
