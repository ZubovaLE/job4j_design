package ru.job4j.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {
    @Test
    @DisplayName("Call findBy when valid value then Optional is present")
    void findByWhenValidValueThenOptionalIsPresent() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(1, 4));
        assertTrue(tree.add(4, 5));
        assertTrue(tree.add(5, 6));
        assertTrue(tree.findBy(6).isPresent());
    }

    @Test
    @DisplayName("Call findBy when invalid value then Optional is empty")
    void findByWhenInvalidValueThenOptionalIsEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertFalse(tree.findBy(7).isPresent());
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

    @Test
    @DisplayName("IsBinary when the leaf is not binary then false")
    void whenIsNotBinary() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(2, 4));
        assertTrue(tree.add(2, 5));
        assertTrue(tree.add(1, 6));
        assertFalse(tree.isBinary());
    }

    @Test
    @DisplayName("IsBinary when the leaf is binary then true")
    void whenIsBinary() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(2, 4));
        assertTrue(tree.add(2, 7));
        assertTrue(tree.add(3, 5));
        assertTrue(tree.isBinary());
    }
}