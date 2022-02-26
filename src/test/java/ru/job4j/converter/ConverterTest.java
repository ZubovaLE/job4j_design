package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ConverterTest {

    @Test
    @DisplayName("Checking something")
    public void whenConvert160dot84RblThen2Dollar() {
        float in = 160;
        float expected = 2;
        float out = Converter.rubleToDollar(in);
        float eps = 0.0001f;
        Assert.assertNotEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Checking something")
    public void whenConvert181dot76RblThen2Euro() {
        float in = 181.76F;
        float expected = 2;
        float out = Converter.rubleToEuro(in);
        float eps = 0.0001f;
        Assert.assertEquals(expected, out, eps);
    }
}
