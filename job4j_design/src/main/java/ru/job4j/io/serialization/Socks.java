package ru.job4j.io.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Objects;

@XmlRootElement(name = "socks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Socks {
    @XmlAttribute
    private boolean uniSex;
    @XmlAttribute
    private float cotton;
    @XmlAttribute
    private String color;

    private Contact contact;
    private String[] characteristics;

    public boolean isUniSex() {
        return uniSex;
    }

    public float getCotton() {
        return cotton;
    }

    public String getColor() {
        return color;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    public Socks() {
    }

    public Socks(boolean uniSex, float cotton, String color, Contact contact, String... characteristics) {
        this.uniSex = uniSex;
        this.cotton = cotton;
        this.color = color;
        this.contact = contact;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Socks{" + "uniSex=" + uniSex
                + ", count=" + cotton
                + ", color='" + color + '\''
                + ", contact=" + contact
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return uniSex == socks.uniSex && Float.compare(socks.cotton, cotton) == 0 && Objects.equals(color, socks.color) && Objects.equals(contact, socks.contact) && Arrays.equals(characteristics, socks.characteristics);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uniSex, cotton, color, contact);
        result = 31 * result + Arrays.hashCode(characteristics);
        return result;
    }
}
