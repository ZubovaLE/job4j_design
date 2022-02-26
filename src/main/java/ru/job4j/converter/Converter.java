package ru.job4j.converter;

public class Converter {

    public static float rubleToEuro(float value) {
        return value / 90.88F;
    }

    public static float rubleToDollar(float value) {
        return value / 80.42F;
    }

    public static void doTaskOne() {
        float euro = Converter.rubleToEuro(450);
        float dollar = Converter.rubleToDollar(450);
        //System.out.println("450 rubles is " + Converter.rubleToDollar(450) + " dollars");
        System.out.println("450 rubles is " + dollar + " dollars");
        System.out.println(euro + " euro");
    }

    public static void doTestForRubleToEuro() {
        float in = 181.76F;
        float expected = 2;
        float out = Converter.rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("The first test result is: " + passed);
    }

    public static void doTestForRubbleToDollar() {
        float in = 160;
        float expected = 2;
        float out = Converter.rubleToDollar(in);
        boolean passed = expected == out;
        System.out.println("The second test result is " + passed);
    }

    public static void main(String[] args) {
        Converter.doTaskOne();
        Converter.doTestForRubleToEuro();
        Converter.doTestForRubbleToDollar();
    }
}
