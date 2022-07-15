package ru.job4j.generic.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {

    @Test
    @DisplayName("Test the .add method when add new User with Petr name")
    public void whenAddAndFindThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Petr"));
    }

    @Test
    @DisplayName("Test the findById method when incorrect id then result is null")
    public void whenAddAndFindThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("10");
        assertNull(result);
    }

    @Test
    @DisplayName("Check that new user is not added when try to add a duplicate")
    public void whenAddDuplicateAndFindUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.add(new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Petr"));
    }

    @Test
    @DisplayName("Test the .replace method when new userName is Maxim")
    public void whenReplaceThenUsernameIsMaxim() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("1", new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Maxim"));
    }

    @Test
    @DisplayName("Test the .replace method when incorrect userName then no userName change")
    public void whenNoReplaceUserThenNoChangeUsername() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("10", new User("10", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Petr"));
    }

    @Test
    @DisplayName("Test the .delete method then .findById returns null")
    public void whenDeleteUserThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("1");
        User result = store.findById("1");
        assertNull(result);
    }

    @Test
    @DisplayName("Test the .delete method when incorrect id then no changes in store")
    public void whenNoDeleteUserThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Petr"));
    }
}