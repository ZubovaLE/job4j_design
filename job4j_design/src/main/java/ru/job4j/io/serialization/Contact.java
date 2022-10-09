package ru.job4j.io.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.Objects;

@XmlRootElement(name = "contact")
public class Contact implements Serializable {
    @XmlAttribute
    private String phone;

    public Contact() {
    }

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact("+7 (111) 111-11-11");

        /* Запись объекта во временный файл, который удалится системой */
        File tempFile = File.createTempFile("source.csv", null);
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        /* Чтение объекта из файла */
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }
}
