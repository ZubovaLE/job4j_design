package ru.job4j.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UserWithHashCodeTest {
    private User first;
    private User second;

    @BeforeEach
    void initData() {
        first = new UserWithHashCode("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        second = new UserWithHashCode("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
    }

    @Test
    @DisplayName("hashCode when objects are equal")
    void testHashCodeWhenEqual() {
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("hashCode when objects are not equal")
    void testHashCodeWhenNotEqual() {
        User third = new UserWithHashCode("Kate", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first.hashCode(), third.hashCode());
    }

    @Test
    @DisplayName("Test default equals")
    void testEquals() {
        User third = new UserWithHashCode("Kate", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
        assertNotEquals(first, second);
        assertNotEquals(first, third);
    }
}