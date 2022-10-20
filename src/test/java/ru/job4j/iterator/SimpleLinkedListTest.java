package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class SimpleLinkedListTest {
    List<Integer> list;

    @BeforeEach
    void initData() {
        list = new SimpleLinkedList<>();
    }

    @Test
    @DisplayName("When add two elements then get them")
    public void whenAddAndGet() {
        list.add(1);
        list.add(2);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("Try to get item when incorrect index then get IndexOutOfBoundsException")
    public void whenGetFromOutOfBoundThenExceptionIsThrown() {
        list.add(1);
        list.add(2);
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.get(2));
    }

    @Test
    @DisplayName("When add one element and call the hasNext method then true")
    public void whenAddIterHasNextTrue() {

        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    @DisplayName("When add one element and call the .next method then get its value")
    public void whenAddIterNextOne() {
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    @DisplayName("When empty list then hasNext returns false")
    public void whenEmptyIterHashNextFalse() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    @DisplayName("When add an element and multiple call hasNext then always true")
    public void whenAddIterMultiHasNextTrue() {
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    @DisplayName("When add elements and call .next then get 1 and 2")
    public void whenAddIterNextOneNextTwo() {
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
    }

    @Test
    @DisplayName("When get iterator twice then each one starts from the beginning")
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        list.add(1);
        list.add(2);
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(1);
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(2);
        assertThat(first.hasNext()).isFalse();
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(1);
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(2);
        assertThat(second.hasNext()).isFalse();
    }

    @Test
    @DisplayName("Call .next when empty list then get NoSuchElementException")
    public void whenEmptyListAndCallNextThenGetNoSuchElementException() {
        Iterator<Integer> iterator = list.iterator();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(iterator::next);
    }

    @Test
    @DisplayName("When add new item after calling an iterator then get ConcurrentModificationException")
    public void whenAddAfterGetIteratorThenMustBeConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(1);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);
    }
}