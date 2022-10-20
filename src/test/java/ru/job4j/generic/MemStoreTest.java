package ru.job4j.generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemStoreTest {
    private MemStore<Role> store;

    @BeforeEach
    public void initData() {
        store = new MemStore<>();
    }

    @Test
    @DisplayName("Add when name = Role1")
    void addAndFindByIdThenNameIsRole1() {
        store.add(new Role("1", "Role1"));
        assertEquals(store.findById("1").getName(), "Role1");
    }

    @Test
    @DisplayName("Add when absent then no changes")
    void addWhenAbsentThenNoChanges() {
        store.add(new Role("1", "Role1"));
        store.add(new Role("1", "Role"));
        assertEquals(store.findById("1").getName(), "Role1");
    }

    @Test
    @DisplayName("findById when incorrect id then result is null")
    public void findByIdWhenIncorrectIdThenNull() {
        store.add(new Role("1", "Role1"));
        Role result = store.findById("11");
        assertNull(result);
    }

    @Test
    @DisplayName("Replace when new name is Role2")
    void testReplaceWhenNewNameIsRole2() {
        store.add(new Role("1", "Role1"));
        store.replace("1", new Role("2", "Role2"));
        Role result = store.findById("1");
        assertEquals(result.getName(), "Role2");
    }

    @Test
    @DisplayName("Replace when incorrect id then false")
    void replaceWhenIncorrectId() {
        store.add(new Role("1", "Role1"));
        assertFalse(store.replace("11", new Role("2", "Role2")));
    }

    @Test
    @DisplayName("Replace when null then false")
    void replaceWhenNullThenFalse() {
        store.add(new Role("1", "Role1"));
        assertFalse(store.replace("1", null));
    }

    @Test
    @DisplayName("When delete then .findById returns null")
    void whenDelete() {
        store.add(new Role("1", "Role1"));
        store.delete("1");
        assertNull(store.findById("1"));
    }

    @Test
    @DisplayName("delete when incorrect id then false")
    void deleteWhenIncorrectId() {
        store.add(new Role("1", "Role1"));
        assertFalse(store.delete("11"));
    }
}