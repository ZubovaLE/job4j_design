package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
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
    void whenAddThenSizeIncrease() {
        assertThat(list).hasSize(3);
    }

    @Test
    void whenRemoveThenGetValueAndSizeDecrease() {
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.remove(1)).isEqualTo(Integer.valueOf(2));
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void whenAddAndGetByCorrectIndex() {
        assertThat(list.get(0)).isEqualTo(Integer.valueOf(1));
    }

    @Test
    void whenAddAndGetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.get(5));
    }

    @Test
    void whenRemoveByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.remove(5));
    }

    @Test
    void whenRemoveThenMustNotBeEmpty() {
        list.remove(1);
        assertThat(list.get(0)).isEqualTo(Integer.valueOf(1));
        assertThat(list.get(1)).isEqualTo(Integer.valueOf(3));
    }

    @Test
    void whenAddNullThenMustBeSameBehavior() {
        list = new SimpleArrayList<>(3);
        list.add(null);
        list.add(null);
        assertThat(list).hasSize(2);
        assertThat(list.get(0)).isNull();
        assertThat(list.get(1)).isNull();
    }

    @Test
    void whenSetThenGetOldValueAndSizeNotChanged() {
        assertThat(list.set(1, 22)).isEqualTo(Integer.valueOf(2));
        assertThat(list).hasSize(3);
    }

    @Test
    void whenSetByIncorrectIndexThenGetException() {
        assertThatIndexOutOfBoundsException().isThrownBy(() -> list.set(5, 22));
    }

    @Test
    void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        list = new SimpleArrayList<>(5);
        assertThat(list.iterator().hasNext()).isFalse();
    }

    @Test
    void whenGetIteratorFromEmptyListThenNextThrowException() {
        list = new SimpleArrayList<>(5);
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> list.iterator().next());
    }

    @Test
    void whenGetIteratorTwiceThenStartAlwaysFromBeginning() {
        assertThat(list.iterator().hasNext()).isTrue();
        assertThat(list.iterator().hasNext()).isTrue();
        assertThat(list.iterator().next()).isEqualTo(Integer.valueOf(1));
    }

    @Test
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
    void whenNoPlaceThenMustIncreaseCapacity() {
        IntStream.range(3, 10).forEach(v -> list.add(v));
        assertThat(list).hasSize(10);
    }

    @Test
    void whenAddAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);
    }

    @Test
    void whenRemoveAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(0);
        assertThatExceptionOfType(ConcurrentModificationException.class).isThrownBy(iterator::next);
    }
}