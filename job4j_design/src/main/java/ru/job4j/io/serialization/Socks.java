package ru.job4j.io.serialization;

import java.util.Arrays;

public class Socks {
    private final boolean isUniSex;
    private final float cotton;
    private final String color;
    private final Contact contact;
    private final String[] characteristics;

    public Socks(boolean isUniSex, float cotton, String color, Contact contact, String[] characteristics) {
        this.isUniSex = isUniSex;
        this.cotton = cotton;
        this.color = color;
        this.contact = contact;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Socks{" + "isAvailable=" + isUniSex
                + ", count=" + cotton
                + ", color='" + color + '\''
                + ", contact=" + contact
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }
}
