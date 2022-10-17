package ru.job4j.io.serialization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MainTest {
    private static final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
    private static final Socks redSocks = new Socks(true, 89.9f, "red", new Contact("123-456"), "Socks", "made of cotton", "demi-season");

    @ParameterizedTest
    @MethodSource("provideParametrizedTestArguments")
    @DisplayName("Get json strings from different objects")
    void getJsonString(Object object, String expected) {
        String result = Main.getJsonString(object);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideParametrizedTestArguments() {
        String expectedPersonJsonString = "{"
                + "\"sex\":false,"
                + "\"age\":30,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"11-111\""
                + "},"
                + "\"statuses\":"
                + "[\"Worker\",\"Married\"]"
                + "}";
        String expectedSocksJsonString = "{"
                + "\"uniSex\":true,"
                + "\"cotton\":89.9,"
                + "\"color\":\"red\","
                + "\"contact\":"
                + "{"
                + "\"phone\":\"123-456\""
                + "},"
                + "\"characteristics\":"
                + "[\"Socks\",\"made of cotton\",\"demi-season\"]"
                + "}";
        return Stream.of(
                Arguments.of(person, expectedPersonJsonString),
                Arguments.of(redSocks, expectedSocksJsonString)
        );
    }

    @Test
    @DisplayName("Get Person from json-string")
    void getPerson() {
        String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        Person result = Main.getPersonFromJsonString(personJson);
        Person expected = new Person(false, 35, new Contact("+7(924)111-111-11-11"), "Student", "Free");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Get Socks from json-string")
    void getSocks() {
        String socksJson = "{\"uniSex\":false, "
                + "\"cotton\":70,"
                + "\"color\":blue,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"123-456\""
                + "},"
                + "\"characteristics\":"
                + "[\"made of cotton\",\"demi-season\"]"
                + "}";
        Socks result = Main.getSocksFromJsonString(socksJson);
        Socks expected = new Socks(false, 70, "blue", new Contact("123-456"), "made of cotton", "demi-season");
        assertThat(result).isEqualTo(expected);
    }
}