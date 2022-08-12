package ru.job4j.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User testUser;

    @BeforeEach
    void init() {
        testUser = new User(123, "Anna");
    }

    @Test
    @DisplayName("Test getId when id = 123 then return 123")
    void getId() {
        assertEquals(123, testUser.getId());
    }

    @Test
    @DisplayName("Set id = 1234 then getId returns 1234")
    void setId() {
        testUser.setId(1234);
        assertEquals(1234, testUser.getId());
    }

    @Test
    @DisplayName("Test getName when name = Anna then return Anna")
    void getName() {
        assertEquals("Anna", testUser.getName());
    }

    @Test
    @DisplayName("Set name = Anna Ivanova then getName returns Anna Ivanova")
    void setName() {
        testUser.setName("Anna Ivanova");
        assertEquals("Anna Ivanova", testUser.getName());
    }

    @Test
    @DisplayName("Test .equals method when objects are equal then true")
    void testEqualsWhenObjectsAreEqual() {
        User similarUser = new User(123, "Anna");
        assertEquals(testUser, similarUser);
    }

    @Test
    @DisplayName("Test .equal method when objects are not equal then false")
    void testEqualsWhenObjectsAreNotEqual() {
        User notSimilarUser = new User(123, "Kate");
        assertNotEquals(testUser, notSimilarUser);
    }

    @Test
    @DisplayName("When objects are equal then their hashCodes are equal")
    void testHashCode() {
        User similarUser = new User(123, "Anna");
        assertEquals(testUser.hashCode(), similarUser.hashCode());
    }

    @Test
    @DisplayName("Check toString")
    void testToString() {
        String expected = "User{id=123, name='Anna'}";
        assertEquals(expected, testUser.toString());
    }
}