package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class ForwardLinkedTest {

    @Test
    @DisplayName("When add one element and delete it and call iterator then .next throws NoSuchElementException")
    public void whenAddElementAndDeleteFirstAndCallNextMethodThenGetNoSuchElementException() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        assertThat(linked.deleteFirst()).isEqualTo(1);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(linked.iterator()::next);
    }

    @Test
    @DisplayName("DeleteFirst when no elements then get NoSuchElementException")
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(linked::deleteFirst);
    }

    @Test
    @DisplayName("When call deleteFirst twice then get one remaining element")
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        assertThat(linked.deleteFirst()).isEqualTo(1);
        assertThat(linked.deleteFirst()).isEqualTo(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next()).isEqualTo(3);
    }

    @Test
    @DisplayName("Add new element after calling an iterator then get ConcurrentModificationException")
    public void whenCallIteratorAndAddNewElementThenGetConcurrentModificationException() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFirst()).isEqualTo(1);
        Iterator<Integer> it = linked.iterator();
        linked.add(3);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(it::next);
    }

    @Test
    @DisplayName("Call deleteFirst after calling an iterator then get ConcurrentModificationException")
    public void whenCallIteratorAndDeleteElementThenGetConcurrentModificationException() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(linked.deleteFirst()).isEqualTo(1);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(it::next);
    }

    @Test
    @DisplayName("Call hasNext when one element then true")
    public void whenEmptyThenHasNextReturnsTrue() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    @DisplayName("Call hasNext when no elements then false")
    public void whenEmptyThenHasNextReturnsFalse() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.hasNext()).isFalse();
    }
}