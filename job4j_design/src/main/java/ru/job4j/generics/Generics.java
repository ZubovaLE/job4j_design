package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
    }

    /**
     * The method has no limits
     *
     * @param list - collection that can store any types
     */
    public void printObject(List<?> list) {
        for (Object el : list) {
            System.out.println("Текущий элемент: " + el);
        }
    }

    /**
     * The method has an upper limit
     *
     * @param list - collection that can store Predator type and its subtypes
     */
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Object el : list) {
            System.out.println("Текущий элемент: " + el);
        }
    }

    /**
     * The method has a lower limit
     *
     * @param list - collection that can store Predator type and its superclasses
     */
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Object el : list) {
            System.out.println("Текущий элемент: " + el);
        }
    }
}
