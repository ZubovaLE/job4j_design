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

    List<Integer> listWithDefaultCapacity;
    List<Integer> listWithCertainCapacity;

    @BeforeEach
    void initData() {
        listWithCertainCapacity = new SimpleArrayList<>(3);
        listWithCertainCapacity.add(1);
        listWithCertainCapacity.add(2);
        listWithCertainCapacity.add(3);

        listWithDefaultCapacity = new SimpleArrayList<>();
        listWithDefaultCapacity.add(1);
        listWithDefaultCapacity.add(2);
        listWithDefaultCapacity.add(3);
    }

    @Test
    @DisplayName("When add 3 elements then size = 3")
    void whenAddThenSizeIncrease() {
        assertThat(listWithCertainCapacity.size()).isEqualTo(3);

        assertThat(listWithDefaultCapacity.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("When remove then get value and decrease size")
    void whenRemoveThenGetValueAndSizeDecrease() {
        assertThat(listWithCertainCapacity.size()).isEqualTo(3);
        assertThat(listWithCertainCapacity.remove(1)).isEqualTo(Integer.valueOf(2));
        assertThat(listWithCertainCapacity.size()).isEqualTo(2);

        assertThat(listWithDefaultCapacity.size()).isEqualTo(3);
        assertThat(listWithDefaultCapacity.remove(1)).isEqualTo(Integer.valueOf(2));
        assertThat(listWithDefaultCapacity.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("When correct index then get element")
    void whenAddAndGetByCorrectIndex() {
        assertThat(listWithCertainCapacity.get(0)).isEqualTo(Integer.valueOf(1));

        assertThat(listWithDefaultCapacity.get(0)).isEqualTo(Integer.valueOf(1));
    }

    @Test
    @DisplayName("Try to get element when incorrect index then get IndexOutOfBoundsException")
    void whenAddAndGetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithCertainCapacity.get(5));

        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithDefaultCapacity.get(5));
    }

    @Test
    @DisplayName("Try to remove element when incorrect index then get IndexOutOfBoundsException")
    void whenRemoveByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithCertainCapacity.remove(5));

        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithDefaultCapacity.remove(5));
    }

    @Test
    @DisplayName("When remove one element then get remaining elements")
    void whenRemoveThenMustNotBeEmpty() {
        listWithCertainCapacity.remove(1);
        assertThat(listWithCertainCapacity.get(0)).isEqualTo(Integer.valueOf(1));
        assertThat(listWithCertainCapacity.get(1)).isEqualTo(Integer.valueOf(3));

        listWithDefaultCapacity.remove(1);
        assertThat(listWithDefaultCapacity.get(0)).isEqualTo(Integer.valueOf(1));
        assertThat(listWithDefaultCapacity.get(1)).isEqualTo(Integer.valueOf(3));
    }

    @Test
    @DisplayName("When add null elements then check the methods work correctly")
    void whenAddNullThenMustBeSameBehavior() {
        listWithCertainCapacity = new SimpleArrayList<>(3);
        listWithCertainCapacity.add(null);
        listWithCertainCapacity.add(null);
        assertThat(listWithCertainCapacity.size()).isEqualTo(2);
        assertThat(listWithCertainCapacity.get(0)).isNull();
        assertThat(listWithCertainCapacity.get(1)).isNull();

        listWithDefaultCapacity = new SimpleArrayList<>();
        listWithDefaultCapacity.add(null);
        listWithDefaultCapacity.add(null);
        assertThat(listWithDefaultCapacity.size()).isEqualTo(2);
        assertThat(listWithDefaultCapacity.get(0)).isNull();
        assertThat(listWithDefaultCapacity.get(1)).isNull();
    }

    @Test
    @DisplayName("When empty list then the size is 0")
    void whenEmptyListThenSizeIs0() {
        listWithCertainCapacity = new SimpleArrayList<>(3);
        assertThat(listWithCertainCapacity.size()).isEqualTo(0);

        listWithDefaultCapacity = new SimpleArrayList<>();
        assertThat(listWithDefaultCapacity.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("When set then get old value and no changes in size")
    void whenSetThenGetOldValueAndSizeNotChanged() {
        assertThat(listWithCertainCapacity.set(1, 22)).isEqualTo(Integer.valueOf(2));
        assertThat(listWithCertainCapacity.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Try to set when incorrect index then get IndexOutOfBoundsException")
    void whenSetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithCertainCapacity.set(5, 22));

        assertThatIndexOutOfBoundsException().isThrownBy(() -> listWithDefaultCapacity.set(5, 22));
    }

    @Test
    @DisplayName("When empty list then hasNext returns false")
    void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        listWithCertainCapacity = new SimpleArrayList<>(5);
        assertThat(listWithCertainCapacity.iterator().hasNext()).isFalse();

        listWithDefaultCapacity = new SimpleArrayList<>(5);
        assertThat(listWithDefaultCapacity.iterator().hasNext()).isFalse();
    }

    @Test
    @DisplayName("Call the next method when empty list then get NoSuchElementException")
    void whenGetIteratorFromEmptyListThenNextThrowException() {
        listWithCertainCapacity = new SimpleArrayList<>(5);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> listWithCertainCapacity.iterator().next());

        listWithDefaultCapacity = new SimpleArrayList<>(5);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> listWithDefaultCapacity.iterator().next());
    }

    @Test
    @DisplayName("When get iterator twice then the next method starts from the beginning")
    void whenGetIteratorTwiceThenStartAlwaysFromBeginning() {
        assertThat(listWithCertainCapacity.iterator().next()).isEqualTo(Integer.valueOf(1));
        assertThat(listWithCertainCapacity.iterator().next()).isEqualTo(Integer.valueOf(1));

        assertThat(listWithDefaultCapacity.iterator().next()).isEqualTo(Integer.valueOf(1));
        assertThat(listWithDefaultCapacity.iterator().next()).isEqualTo(Integer.valueOf(1));
    }

    @Test
    @DisplayName("Check iterator")
    void whenCheckIterator() {
        Iterator<Integer> iterator = listWithCertainCapacity.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(1));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(2));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(Integer.valueOf(3));
        assertThat(iterator.hasNext()).isFalse();

        Iterator<Integer> secondIterator = listWithDefaultCapacity.iterator();
        assertThat(secondIterator.hasNext()).isTrue();
        assertThat(secondIterator.next()).isEqualTo(Integer.valueOf(1));
        assertThat(secondIterator.hasNext()).isTrue();
        assertThat(secondIterator.next()).isEqualTo(Integer.valueOf(2));
        assertThat(secondIterator.hasNext()).isTrue();
        assertThat(secondIterator.next()).isEqualTo(Integer.valueOf(3));
        assertThat(secondIterator.hasNext()).isFalse();
    }

    @Test
    @DisplayName("When try to add new element but the list is full then increase the capacity")
    void whenNoPlaceThenMustIncreaseCapacity() {
        IntStream.range(3, 10).forEach(v -> listWithCertainCapacity.add(v));
        assertThat(listWithCertainCapacity.size()).isEqualTo(10);

        IntStream.range(3, 15).forEach(v -> listWithDefaultCapacity.add(v));
        assertThat(listWithDefaultCapacity.size()).isEqualTo(15);
    }

    @Test
    @DisplayName("When add new element after calling an iterator then get ConcurrentModificationException")
    void whenAddAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = listWithCertainCapacity.iterator();
        listWithCertainCapacity.add(4);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);

        Iterator<Integer> secondIterator = listWithDefaultCapacity.iterator();
        listWithDefaultCapacity.add(4);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(secondIterator::next);
    }

    @Test
    @DisplayName("When remove an element after calling an iterator then get ConcurrentModificationException")
    void whenRemoveAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = listWithCertainCapacity.iterator();
        listWithCertainCapacity.add(0);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);

        Iterator<Integer> secondIterator = listWithDefaultCapacity.iterator();
        listWithDefaultCapacity.add(0);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(secondIterator::next);
    }
}