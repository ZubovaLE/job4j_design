package ru.job4j.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UserWithEqualsAndHashCodeTest {
    private User first;
    private User second;

    @BeforeEach
    void initData() {
        first = new UserWithEqualsAndHashCode("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        second = new UserWithEqualsAndHashCode("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
    }

    @Test
    @DisplayName("hashCode when objects are equal")
    void testHashCodeWhenEqual() {
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("hashCode when objects are not equal")
    void testHashCodeWhenNotEqual() {
        User third = new UserWithEqualsAndHashCode("Kate", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first.hashCode(), third.hashCode());
    }

    @Test
    @DisplayName("equals when objects are equal then true")
    void testEqualsWhenObjectsAreEqualThenTrue() {
        assertEquals(first, second);
    }

    @Test
    @DisplayName("equals when objects are not equal then false")
    void testEqualsWhenObjectsAreNotEqualThenFalse() {
        User third = new UserWithEqualsAndHashCode("Kate", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first, third);
    }
}