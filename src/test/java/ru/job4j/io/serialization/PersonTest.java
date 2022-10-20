package ru.job4j.io.serialization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private final Person person = new Person(true, 30, new Contact("11"), "Student", "Free");

    @Test
    @DisplayName("Test isSex when true then return true")
    void testIsSexWhenTrue() {
        assertTrue(person.isSex());
    }

    @Test
    @DisplayName("Test getAge when 30 then return 30")
    void testGetAgeWhen30() {
        int expected = 30;
        assertEquals(expected, person.getAge());
    }

    @Test
    @DisplayName("Test getContact")
    void testGetContact() {
        Contact expected = new Contact("11");
        assertEquals(expected, person.getContact());
    }
}