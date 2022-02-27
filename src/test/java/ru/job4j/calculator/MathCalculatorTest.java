package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MathCalculatorTest {

    @Test
    @DisplayName("Checking the first method")
    public void addAndMultipleWhen10And20() {
        double first = 10;
        double second = 20;
        double expected = 230;
        double out = MathCalculator.addAndMultiple(first, second);
        double eps = 0.0001;
        Assert.assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Checking the second method")
    public void subAndDivWhen10And5() {
        double first = 10;
        double second = 5;
        double expected = 7;
        double out = MathCalculator.subAndDiv(first, second);
        double eps = 0.0001;
        Assert.assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Checking the third method")
    public void sumOfAllMethods4And2() {
        double first = 4;
        double second = 2;
        double expected = 18;
        double out = MathCalculator.sumOfAllMethods(first, second);
        double eps = 0.0001;
        Assert.assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Checking the third method again")
    public void sumOfAllMethods7And3() {
        double first = 7;
        double second = 3;
        double expected = 37.3333;
        double out = MathCalculator.sumOfAllMethods(first, second);
        double eps = 0.0001;
        Assert.assertEquals(expected, out, eps);
    }
}