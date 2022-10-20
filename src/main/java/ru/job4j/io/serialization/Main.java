package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static final Gson GSON = new GsonBuilder().create();

    public static String getJsonString(Object object) {
        return GSON.toJson(object);
    }

    public static Person getPersonFromJsonString(String jsonString) {
        return GSON.fromJson(jsonString, Person.class);
    }

    public static Socks getSocksFromJsonString(String jsonString) {
        return GSON.fromJson(jsonString, Socks.class);
    }

    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        final Socks redSocks = new Socks(true, 89.9f, "red", new Contact("123-456"), "Socks", "made of cotton", "demi-season");

        System.out.println("Convert a person object to a json string:");
        System.out.println(getJsonString(person));

        System.out.println("Modify json-string:");
        final String personJson =
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
        final Person personMod = getPersonFromJsonString(personJson);
        System.out.println(personMod);
        System.out.println();

        System.out.println("Convert socks object to a json string:");
        System.out.println(getJsonString(redSocks));

        System.out.println("Modify json-string:");
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
        final Socks socksMod = getSocksFromJsonString(socksJson);
        System.out.println(socksMod);
    }
}