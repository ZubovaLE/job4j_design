package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessTest {

    @Test
    @DisplayName("Test the calc method when ivan = 90, nik = 100, then result = 1")
    void testCalcWhenIvanIs90AndNikitaIs100Then2Months() {
        int ivan = 90;
        int nik = 100;
        int out = Fitness.calc(ivan, nik);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when ivan equals nik, then result = 1")
    void whenIvanEqualsNik() {
        int ivan = 50;
        int nik = 50;
        int out = Fitness.calc(ivan, nik);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the calc method when Ivan is greater then Nik")
    public void whenIvanGreatNik() {
        int ivan = 95;
        int nik = 90;
        int result = Fitness.calc(ivan, nik);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the calc method when Ivan is less by one Nik")
    public void whenIvanLessByOneNik() {
        int ivan = 90;
        int nik = 95;
        int result = Fitness.calc(ivan, nik);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the calc method when ivan = 50,  nik = 90, then result is 2 months")
    public void whenIvanLessByFewNik() {
        int ivan = 50;
        int nik = 90;
        int result = Fitness.calc(ivan, nik);
        int expected = 2;
        assertEquals(expected, result);
    }
}