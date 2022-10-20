package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocksTest {
    private final Gson gson = new GsonBuilder().create();

    @Test
    @DisplayName("Convert Socks object to a json string")
    void checkObjectDescriptionInJsonFormat() {
        final Socks redSocks = new Socks(
                true,
                89.9f,
                "red",
                new Contact("123-456"),
                "Socks", "made of cotton", "demi-season");

        String expected = "{\"uniSex\":true,"
                + "\"cotton\":89.9,"
                + "\"color\":\"red\","
                + "\"contact\":"
                + "{"
                + "\"phone\":\"123-456\""
                + "},"
                + "\"characteristics\":"
                + "[\"Socks\",\"made of cotton\",\"demi-season\"]"
                + "}";
        String result = gson.toJson(redSocks);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Get Socks object from a json-string")
    void getObjectFromJsonString() {
        String socksJson = "{\"uniSex\":true, "
                + "\"cotton\":89.9,"
                + "\"color\":red,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"123-456\""
                + "},"
                + "\"characteristics\":"
                + "[\"Socks\",\"made of cotton\",\"demi-season\"]"
                + "}";

        Socks expected = new Socks(
                true,
                89.9f,
                "red",
                new Contact("123-456"),
                "Socks", "made of cotton", "demi-season");
        Socks result = gson.fromJson(socksJson, Socks.class);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Check getters")
    void checkGetters() {
        Socks redSocks = new Socks(
                true,
                89.9f,
                "red",
                new Contact("123-456"),
                "Socks", "made of cotton", "demi-season");
        Float actualCotton = redSocks.getCotton();
        String actualColor = redSocks.getColor();
        Contact actualContact = redSocks.getContact();

        Float expectedCotton = 89.9f;
        String expectedColor = "red";
        Contact expectedContact = new Contact("123-456");

        assertEquals(expectedCotton, actualCotton);
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedContact, actualContact);
    }
}