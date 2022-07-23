package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.list.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class SimpleArrayListTest {

    List<Integer> list;

    @BeforeEach
    void initData() {
        list = new SimpleArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    @DisplayName("Test add when add 3 elements then size = 3")
    void whenAddThenSizeIncrease() {
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("When remove then get value and decrease size")
    void whenRemoveThenGetValueAndSizeDecrease() {
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.remove(1)).isEqualTo(Integer.valueOf(2));
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("When correct index then get element")
    void whenAddAndGetByCorrectIndex() {
        assertThat(list.get(0)).isEqualTo(Integer.valueOf(1));
    }

    @Test
    @DisplayName("Try to get element when incorrect index then get IndexOutOfBoundsException")
    void whenAddAndGetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.get(5));
    }

    @Test
    @DisplayName("Try to remove element when incorrect index then get IndexOutOfBoundsException")
    void whenRemoveByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.remove(5));
    }

    @Test
    @DisplayName("When remove one element then get remaining elements")
    void whenRemoveThenMustNotBeEmpty() {
        list.remove(1);
        assertThat(list.get(0)).isEqualTo(Integer.valueOf(1));
        assertThat(list.get(1)).isEqualTo(Integer.valueOf(3));
    }

    @Test
    @DisplayName("When add null elements then check the methods work correctly")
    void whenAddNullThenMustBeSameBehavior() {
        list = new SimpleArrayList<>(3);
        list.add(null);
        list.add(null);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isNull();
        assertThat(list.get(1)).isNull();
    }

    @Test
    @DisplayName("When empty list then the size is 0")
    void whenEmptyListThenSizeIs0() {
        list = new SimpleArrayList<>(3);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("When set then get old value and no changes in size")
    void whenSetThenGetOldValueAndSizeNotChanged() {
        assertThat(list.set(1, 22)).isEqualTo(Integer.valueOf(2));
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Try to set when incorrect index then get IndexOutOfBoundsException")
    void whenSetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.set(5, 22));
    }

    @Test
    @DisplayName("When empty list then hasNext returns false")
    void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        list = new SimpleArrayList<>(5);
        assertThat(list.iterator().hasNext()).isFalse();
    }

    @Test
    @DisplayName("Call the next method when empty list then get NoSuchElementException")
    void whenGetIteratorFromEmptyListThenNextThrowException() {
        list = new SimpleArrayList<>(5);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> list.iterator().next());
    }

    @Test
    @DisplayName("When call hasNext twice then the next method starts from the beginning")
    void whenGetIteratorTwiceThenStartAlwaysFromBeginning() {
        assertThat(list.iterator().hasNext()).isTrue();
        assertThat(list.iterator().hasNext()).isTrue();
        assertThat(list.iterator().next()).isEqualTo(Integer.valueOf(1));
    }

    @Test
    @DisplayName("Check iterator")
    void whenCheckIterator() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(1));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(2));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(3));
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    @DisplayName("When try to add new element but the list is full then increase the capacity")
    void whenNoPlaceThenMustIncreaseCapacity() {
        IntStream.range(3, 10).forEach(v -> list.add(v));
        assertThat(list.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("When add new element after calling an iterator then get ConcurrentModificationException")
    void whenAddAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);
    }

    @Test
    @DisplayName("When remove an element after calling an iterator then get ConcurrentModificationException")
    void whenRemoveAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(0);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);
    }
}