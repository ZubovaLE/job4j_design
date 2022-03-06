package ru.job4j.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageTest {

    @Test
    @DisplayName("Test the year method when amount is greater then salary, then year = 4")
    void testYearWhenAmountIs100SalaryIs70PercentIs50ThenYearIS4() {
        double amount = 100;
        double salary = 70;
        double percent = 50;
        int out = Mortgage.year(amount, salary, percent);
        int expected = 4;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the year method when salary equals total amount, then year = 1")
    void testWhenSalaryEqualsTotalAmount() {
        double amount = 100;
        double salary = 150;
        double percent = 50;
        int out = Mortgage.year(amount, salary, percent);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the year method when salary is greater then amount but less then total amount")
    void testWhenSalaryGreaterAmount() {
        double amount = 100;
        double salary = 120;
        double percent = 50;
        int out = Mortgage.year(amount, salary, percent);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the year method when amount = 1000, salary = 1200, percent = 1, then year = 1")
    public void when1Year() {
        int amount = 1000;
        int salary = 1200;
        double percent = 1;
        int result = Mortgage.year(amount, salary, percent);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the year method when amount = 100, salary = 150, percent = 100, then year = 2")
    public void when2Year() {
        int amount = 100;
        int salary = 150;
        double percent = 100;
        int result = Mortgage.year(amount, salary, percent);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the year method when amount = -100, then year = 0")
    public void testYearWhenAmountIsMinusThenYearIs0() {
        int amount = -100;
        int salary = 150;
        double percent = 100;
        int result = Mortgage.year(amount, salary, percent);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test the year method when amount = 0, then year = 0")
    public void testYearWhenAmountIs0ThenYearIs0() {
        int amount = 0;
        int salary = 150;
        double percent = 100;
        int result = Mortgage.year(amount, salary, percent);
        int expected = 0;
        assertEquals(expected, result);
    }
}