package ru.job4j.io.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class UsageOfJAXB {
    public static String serializePersonsWithJAXB(JAXBContext context, Person person) throws Exception {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            return writer.getBuffer().toString();
        }

    }

    public static String serializeSocksWithJAXB(JAXBContext context, Socks socks) throws Exception {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(socks, writer);
            return writer.getBuffer().toString();
        }
    }

    public static Person deserializePersonWithJAXB(JAXBContext context, String xml) throws Exception {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            return (Person) unmarshaller.unmarshal(reader);
        }
    }

    public static Socks deserializeSocksWithJAXB(JAXBContext context, String xml) throws Exception {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            return (Socks) unmarshaller.unmarshal(reader);
        }
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        Socks socks = new Socks(true, 89.99f, "red", new Contact("123-456"), "socks", "made of cotton", "demi-season");

        /* Получаем контекст для доступа к API */
        JAXBContext personContext = JAXBContext.newInstance(Person.class);
        JAXBContext socksContext = JAXBContext.newInstance(Socks.class);

        /* сериализуем */
        String personXml = serializePersonsWithJAXB(personContext, person);
        System.out.println(personXml);
        String socksXml = serializeSocksWithJAXB(socksContext, socks);
        System.out.println(socksXml);

        /* десериализуем */
        Person personResult = deserializePersonWithJAXB(personContext, personXml);
        System.out.println(personResult);
        Socks socksResult = deserializeSocksWithJAXB(socksContext, socksXml);
        System.out.println(socksResult);
    }
}
