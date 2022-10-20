package ru.job4j.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void initData() {
        user = new User("Anna", 2, new GregorianCalendar(1975, Calendar.JANUARY, 12));
    }

    @Test
    @DisplayName("getName when name = Anna")
    void getName() {
        assertEquals("Anna", user.getName());
    }

    @Test
    @DisplayName("getChildren when children = 2")
    void getChildren() {
        assertEquals(2, user.getChildren());
    }
}