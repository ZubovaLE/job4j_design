package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeMaxTest {

    @Test
    @DisplayName("Test the Max method when the third is max")
    void maxWhenXIs3YIs4ZIs5() {
        int first = 3;
        int second = 4;
        int third = 5;
        int out = ThreeMax.max(first, second, third);
        int expected = 5;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the Max method when the first is max")
    public void firstMax() {
        int first = 10;
        int second = 5;
        int third = 1;
        int result = ThreeMax.max(first, second, third);
        int expected = 10;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the Max method when the second is max")
    public void secondMax() {
        int first = 10;
        int second = 50;
        int third = 1;
        int result = ThreeMax.max(first, second, third);
        int expected = 50;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the Max method when all numbers are equal")
    public void allEq() {
        int first = 1;
        int second = 1;
        int third = 1;
        int result = ThreeMax.max(first, second, third);
        int expected = 1;
       assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the Max method when the first and the second numbers are equal")
    public void firstEqSecond() {
        int first = 10;
        int second = 10;
        int third = 1;
        int result = ThreeMax.max(first, second, third);
        int expected = 10;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the Max method when the first and the third numbers are equal")
    public void firstEqThird() {
        int first = 100;
        int second = 1;
        int third = 100;
        int result = ThreeMax.max(first, second, third);
        int expected = 100;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the Max method when the second and the third numbers are equal")
    public void secondEqThird() {
        int first = 1;
        int second = 100;
        int third = 100;
        int result = ThreeMax.max(first, second, third);
        int expected = 100;
        assertEquals(expected, result);
    }
}