package ru.job4j.collection;

public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * The method deletes the first element and returns its value
     *
     * @return value
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * The method adds an element to the top of the list
     *
     * @param value - the value to add
     */
    public void push(T value) {
        linked.addFirst(value);
    }
}
