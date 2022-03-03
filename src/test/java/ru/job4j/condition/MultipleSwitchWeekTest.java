package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleSwitchWeekTest {

    @Test
    @DisplayName("Test the numberOfDay method when Monday then result is 1")
    void numberOfDayWhenMondayThen1() {
        String name = "Monday";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Вторник then result is 2")
    void numberOfDayWhenTuesdayThen2() {
        String name = "Вторник";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Wednesday then result is 3")
    void numberOfDayWhenWednesdayThen3() {
        String name = "Wednesday";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 3;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Четверг then result is 4")
    void numberOfDayWhenThursdayThen4() {
        String name = "Четверг";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 4;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Friday then result is 5")
    void numberOfDayWhenFridayThen5() {
        String name = "Friday";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 5;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Суббота then result is 6")
    void numberOfDayWhenSaturdayThen6() {
        String name = "Суббота";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 6;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when Sunday then result is 6")
    void numberOfDayWhenSundayThen7() {
        String name = "Sunday";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = 7;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the numberOfDay method when wrong name then result is -1")
    void numberOfDayWhenWrongName() {
        String name = "Something";
        int out = MultipleSwitchWeek.numberOfDay(name);
        int expected = -1;
        assertEquals(expected, out);
    }
}