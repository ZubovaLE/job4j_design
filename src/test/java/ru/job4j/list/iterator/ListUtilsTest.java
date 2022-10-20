package ru.job4j.list.iterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    @Test
    @DisplayName("AddBefore when valid index then the list is changed")
    void addBeforeWhenValidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("AddBefore when invalid index then get IndexOutOfBoundsException")
    void addBeforeWhenInvalidIndexThenIndexOutOfBoundsException() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        assertThatIndexOutOfBoundsException().isThrownBy(() -> ListUtils.addBefore(input, 3, 2));
    }

    @Test
    @DisplayName("AddBefore when null elements then the method works correctly")
    void addBeforeWhenNullElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addBefore(input, 1, null);
        ListUtils.addBefore(input, 1, null);
        assertThat(input).isEqualTo(Arrays.asList(0, null, null, 1, 2));
    }

    @Test
    @DisplayName("AddBefore when empty list then get IndexOutOfBoundsException")
    void addBeforeWhenEmptyListThenIndexOutOfBoundsException() {
        List<Integer> input = new ArrayList<>();
        assertThatIndexOutOfBoundsException().isThrownBy(() -> ListUtils.addBefore(input, 0, 1));
    }

    @Test
    @DisplayName("AddAfter when the last element")
    void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input).isEqualTo(Arrays.asList(0, 1, 2, 3));
    }

    @Test
    @DisplayName("AddAfter when null elements then the method works correctly")
    void addAfterWhenNullElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, null);
        ListUtils.addAfter(input, 1, null);
        assertThat(input).isEqualTo(Arrays.asList(0, 1, null, null, 2));
    }

    @Test
    @DisplayName("AddAfter when empty list then get IndexOutOfBoundsException")
    void addAfterWhenEmptyListThenIndexOutOfBoundsException() {
        List<Integer> input = new ArrayList<>();
        assertThatIndexOutOfBoundsException().isThrownBy(() -> ListUtils.addAfter(input, 0, 1));
    }

    @Test
    @DisplayName("Test removeIf")
    void removeIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> filter = s -> s > 1;
        ListUtils.removeIf(input, filter);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test removeIf when null predicate then get NullPointerException")
    void removeIfWhenNullPredicate() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        assertThatNullPointerException().isThrownBy(() -> ListUtils.removeIf(input, null));
    }

    @Test
    @DisplayName("Test replaceIf")
    void replaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> filter = s -> s > 1;
        ListUtils.replaceIf(input, filter, -1);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, -1, -1));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test replaceIf when null predicate then get NullPointerException")
    void replaceIfWhenNullPredicate() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        assertThatNullPointerException().isThrownBy(() -> ListUtils.replaceIf(input, null, 1));
    }

    @Test
    @DisplayName("Test removeAll")
    void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        List<Integer> elementsForRemoving = new ArrayList<>(Arrays.asList(2, 1));
        ListUtils.removeAll(input, elementsForRemoving);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("RemoveAll when null elements then the method works correctly")
    void removeAllWhenNull() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, null, null, 3));
        List<Integer> elementsForRemoving = new ArrayList<>(Arrays.asList(1, null));
        ListUtils.removeAll(input, elementsForRemoving);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, null, 3));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("RemoveAll when duplicates then the first of them will be deleted")
    void removeAllWhenDuplicates() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 3));
        List<Integer> elementsForRemoving = new ArrayList<>(Arrays.asList(0, 1));
        ListUtils.removeAll(input, elementsForRemoving);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("RemoveAll when duplicates in elements for removing")
    void removeAllWhenDuplicatesAmongElementsForRemoving() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 3));
        List<Integer> elementsForRemoving = new ArrayList<>(Arrays.asList(1, 1));
        ListUtils.removeAll(input, elementsForRemoving);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("RemoveAll when null collection then get NullPointerException")
    void removeAllWhenNullCollection() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1));
        assertThatNullPointerException().isThrownBy(() -> ListUtils.removeAll(input, null));
    }
}