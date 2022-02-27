package ru.job4j.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitTest {

    @Test
    @DisplayName("Test method manWeight when height = 185, result = 97.75")
    void manWeightWhenHeightIs185Should98() {
        short in = 185;
        double expected = 97.75;
        double out = Fit.manWeight(in);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Test method womanWeight when height = 165, result = 74.75")
    void womanWeightWhenHeightIs165Should75() {
        short in = 165;
        double expected = 63.25;
        double out = Fit.womanWeight(in);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Test method womanWeight when height = 170, result 69")
    void whenWoman170Then69() {
        short in = 170;
        double expected = 69;
        double out = Fit.womanWeight(in);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }
}