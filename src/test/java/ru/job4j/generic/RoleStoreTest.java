package ru.job4j.generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.generic.Role;
import ru.job4j.generic.RoleStore;

import static org.junit.jupiter.api.Assertions.*;

class RoleStoreTest {

    private RoleStore store;

    @BeforeEach
    public void setUp() {
        store = new RoleStore();
    }

    @Test
    @DisplayName("Test the .add method when add new Role with Role1 name")
    void testAddWhenAddAndFindByIdThenNameIsRole1() {
        store.add(new Role("1", "Role1"));
        Role result = store.findById("1");
        assertEquals(result.getName(), "Role1");
    }

    @Test
    @DisplayName("Check that new Role is not added when try to add a duplicate")
    void testAddWhenTryToAddDuplicateThenNoNameChange() {
        store.add(new Role("1", "Role1"));
        store.add(new Role("1", "Role2"));
        Role result = store.findById("1");
        assertEquals(result.getName(), "Role1");
    }

    @Test
    @DisplayName("Test the findById method when incorrect id then result is null")
    public void testFindByIdWhenIncorrectIdThenNull() {
        store.add(new Role("1", "Role1"));
        Role result = store.findById("11");
        assertNull(result);
    }

    @Test
    @DisplayName("Test the .replace method when new name is Role2")
    void testReplaceWhenNewNameIsRole2() {
        store.add(new Role("1", "Role1"));
        store.replace("1", new Role("2", "Role2"));
        Role result = store.findById("1");
        assertEquals(result.getName(), "Role2");
    }

    @Test
    @DisplayName("Test the .replace method when incorrect id then false")
    void replaceWhenIncorrectId() {
        store.add(new Role("1", "Role1"));
        assertFalse(store.replace("11", new Role("2", "Role2")));
    }

    @Test
    @DisplayName("Test the .delete method then .findById returns null")
    void delete() {
        store.add(new Role("1", "Role1"));
        store.delete("1");
        assertNull(store.findById("1"));
    }

    @Test
    @DisplayName("Test the .delete method when incorrect id then false")
    void deleteWhenIncorrectId() {
        store.add(new Role("1", "Role1"));
        assertFalse(store.delete("11"));
    }
}