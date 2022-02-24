package ru.job4j.converter;

public class Converter {

    public static float rubleToEuro(float value) {
        float euro = value / 90.88F;
        return euro;
    }

    public static float rubleToDollar(float value) {
        return value / 80.42F;
    }

    public static void main(String[] args) {
        float euro = Converter.rubleToEuro(450);
        float dollar = Converter.rubleToDollar(450);
        //System.out.println("450 rubles is " + Converter.rubleToDollar(450) + " dollars");
        System.out.println("450 rubles is " + dollar + " dollars");
        System.out.println(euro + " euro");
    }
}
