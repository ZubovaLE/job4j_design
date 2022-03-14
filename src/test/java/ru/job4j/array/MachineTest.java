package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @Test
    @DisplayName("Test change method when money equals price")
    public void testChangeWhenMoneyEqualsPrice() {
        int money = 100;
        int price = 100;
        int[] result = Machine.change(money, price);
        int[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test change method when money = 50, price = 35")
    public void testChangeWhen50by35() {
        int money = 50;
        int price = 35;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 5};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test change method when money = 50, price = 21")
    public void testChangeWhen50by21() {
        int money = 50;
        int price = 21;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 10, 5, 2, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test change method when money = 50, price = 32")
    public void testChangeWhen50by32() {
        int money = 50;
        int price = 32;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 5, 2, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test change method when money = 100, price = 12")
    public void testChangeWhen100by12() {
        int money = 100;
        int price = 12;
        int[] result = Machine.change(money, price);
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 10, 5, 2, 1};
        assertArrayEquals(expected, result);
    }
}