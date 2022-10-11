package ru.job4j.io.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    private Contact contact;

    private String[] statuses;

    public Person() {
    }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sex == person.sex && age == person.age && Objects.equals(contact, person.contact) && Arrays.equals(statuses, person.statuses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sex, age, contact);
        result = 31 * result + Arrays.hashCode(statuses);
        return result;
    }
}
