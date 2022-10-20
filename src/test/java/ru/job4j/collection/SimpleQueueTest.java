package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class SimpleQueueTest {

    @Test
    @DisplayName("When push 1 then pop")
    public void whenPushPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);

        int rsl = queue.pop();
        assertThat(rsl).isEqualTo(1);
    }

    @Test
    @DisplayName("When push twice then pop")
    public void when2PushThenPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        int rsl = queue.pop();
        assertThat(rsl).isEqualTo(1);
    }

    @Test
    @DisplayName("When push and pop twice")
    public void when2PushPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.pop();
        queue.push(2);
        int rsl = queue.pop();
        assertThat(rsl).isEqualTo(2);
    }

    @Test
    @DisplayName("Try to pop when no elements then get NoSuchElementException")
    public void whenEmptyPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(queue::pop);
    }

    @Test
    @DisplayName("When push twice, pop and push then pop")
    public void whenPushPushPopPushThenPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        assertThat(queue.pop()).isEqualTo(2);
    }
}