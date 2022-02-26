package ru.job4j.converter;

public class Converter {

    public static float rubleToEuro(float value) {
        return value / 90.88F;
    }

    public static float rubleToDollar(float value) {
        return value / 80.42F;
    }

    public static void main(String[] args) {
        Converter.doTaskOne();
        Converter.doTestForRubleToEuro();
        Converter.doTestForRubbleToDollar();
    }
}
