package ru.job4j.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {
    @ParameterizedTest
    @DisplayName("Test findBy for valid and invalid values")
    @CsvSource(value = {"6, true", "7, false"})
    void findBy(int value, boolean result) {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(2, 3));
        assertTrue(tree.add(1, 6));
        assertEquals(result, tree.findBy(value).isPresent());
    }

    @Test
    @DisplayName("Try to add when child already exists then false")
    void whenChildExistsOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(2, 5));
        assertTrue(tree.add(5, 6));
        assertFalse(tree.add(2, 6));
    }

    @Test
    @DisplayName("Try to add when parent is not found then false")
    void tryToAddWhenParentIsNotFoundThenFalse() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertFalse(tree.add(2, 6));
    }

    @ParameterizedTest
    @DisplayName("Check if a tree is binary")
    @CsvSource(value = {"1, 6, false", "3, 6, true"})
    void isBinary(int parent, int child, boolean result) {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(2, 4));
        assertTrue(tree.add(2, 5));
        assertTrue(tree.add(parent, child));
        assertEquals(result, tree.isBinary());
    }
}