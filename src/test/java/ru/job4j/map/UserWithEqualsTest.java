package ru.job4j.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UserWithEqualsTest {
    private User first;
    private User second;

    @BeforeEach
    void initData() {
        first = new UserWithEquals("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        second = new UserWithEquals("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
    }

    @Test
    @DisplayName("Test default hashCode")
    void testHashCode() {
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("equals when objects are equal then true")
    void testEqualsWhenEqualThenTrue() {
        assertEquals(first, second);
    }

    @Test
    @DisplayName("equals when objects are not equal then false")
    void testEqualsWhenChildrenNotEqualThenFalse() {
        User third = new UserWithEquals("Anna", 3, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first, third);
        assertNotEquals(second, third);
    }

    @Test
    @DisplayName("equals when objects are not equal then false")
    void testEqualsWhenNameNotEqualThenFalse() {
        User third = new UserWithEquals("Kate", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first, third);
        assertNotEquals(second, third);
    }

    @Test
    @DisplayName("equals when objects are not equal then false")
    void testEqualsWhenBirthdayNotEqualThenFalse() {
        User third = new UserWithEquals("Anna", 2, new GregorianCalendar(1974, Calendar.JANUARY, 12));
        assertNotEquals(first, third);
        assertNotEquals(second, third);
    }
}