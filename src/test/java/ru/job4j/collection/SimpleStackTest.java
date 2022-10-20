package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleStackTest {

    @Test
    @DisplayName("When push one element then pop it")
    public void whenPushThenPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    @DisplayName("When push and pop then push and pop")
    public void whenPushPopThenPushPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
    }

    @Test
    @DisplayName("When push twice then pop twice")
    public void whenPushTwiceThenPopTwice() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop()).isEqualTo(1);
    }
}