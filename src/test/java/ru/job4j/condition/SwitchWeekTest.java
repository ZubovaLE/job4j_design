package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchWeekTest {

    @Test
    @DisplayName("Test the nameOfDay method when day = 1 then result is Monday")
    void nameOfDayWhen1ThenMonday() {
        int day = 1;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Monday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 2 then result is Tuesday")
    void nameOfDayWhen2ThenTuesday() {
        int day = 2;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Tuesday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 3 then result is Wednesday")
    void nameOfDayWhen3ThenWednesday() {
        int day = 3;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Wednesday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 4 then result is Thursday")
    void nameOfDayWhen4ThenThursday() {
        int day = 4;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Thursday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 5 then result is Friday")
    void nameOfDayWhen5ThenFriday() {
        int day = 5;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Friday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 6 then result is Saturday")
    void nameOfDayWhen6ThenSaturday() {
        int day = 6;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Saturday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when day = 7 then result is Sunday")
    void nameOfDayWhen7ThenSunday() {
        int day = 7;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Sunday";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the nameOfDay method when the number of the day is out of range")
    void nameOfDayWhenTheDayIsOutOfRange() {
        int day = 13;
        String out = SwitchWeek.nameOfDay(day);
        String expected = "Error. The number is out of range";
        assertEquals(expected, out);
    }
}