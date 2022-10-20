package ru.job4j.io.serialization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;

import static org.junit.jupiter.api.Assertions.*;

class UsageOfJAXBTest {
    @Test
    @DisplayName("Test serializePersonsWithJAXB")
    void testSerializePersonsWithJAXB() throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JAXBContext personContext = JAXBContext.newInstance(Person.class);
        String result = UsageOfJAXB.serializePersonsWithJAXB(personContext, person);
        String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <person sex="false" age="30">
                    <contact phone="11-111"/>
                    <statuses>Worker</statuses>
                    <statuses>Married</statuses>
                </person>
                """;
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("Test deSerializePersonsWithJAXB")
    void testDeserializePersonsWithJAXB() throws Exception {
        JAXBContext personContext = JAXBContext.newInstance(Person.class);
        String personXml = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <person sex="false" age="30">
                <contact phone="11-111"/>
                <statuses>Worker</statuses>
                <statuses>Married</statuses>
                </person>""";
        Person result = UsageOfJAXB.deserializePersonWithJAXB(personContext, personXml);
        Person expected = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test serializeSocksWithJAXB")
    void testSerializeSocksWithJAXB() throws Exception {
        Socks socks = new Socks(true, 89.99f, "red", new Contact("123-456"), "socks", "made of cotton", "demi-season");
        JAXBContext socksContext = JAXBContext.newInstance(Socks.class);
        String result = UsageOfJAXB.serializeSocksWithJAXB(socksContext, socks);
        String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <socks uniSex="true" cotton="89.99" color="red">
                    <contact phone="123-456"/>
                    <characteristics>socks</characteristics>
                    <characteristics>made of cotton</characteristics>
                    <characteristics>demi-season</characteristics>
                </socks>
                """;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test deSerializeSocksWithJAXB")
    void testDeserializeSocksWithJAXB() throws Exception {
        JAXBContext socksContext = JAXBContext.newInstance(Socks.class);
        String socksXml = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                   <socks uniSex="true" cotton="89.99" color="red">
                       <contact phone="123-456"/>
                       <characteristics>socks</characteristics>
                       <characteristics>made of cotton</characteristics>
                       <characteristics>demi-season</characteristics>
                   </socks>""";
        Socks result = UsageOfJAXB.deserializeSocksWithJAXB(socksContext, socksXml);
        Socks expected = new Socks(true, 89.99f, "red", new Contact("123-456"), "socks", "made of cotton", "demi-season");
        assertEquals(expected, result);
    }
}