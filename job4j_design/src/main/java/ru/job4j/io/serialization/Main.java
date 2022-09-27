package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), new String[]{"Worker", "Married"});

        System.out.println("convert a person object to a json string");
        final Gson personGson = new GsonBuilder().create();
        System.out.println(personGson.toJson(person));

        System.out.println("Modifying json-string");
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
        final Person personMod = personGson.fromJson(personJson, Person.class);
        System.out.println(personMod);

        final Socks redSocks = new Socks(true, 89.9f, "red", new Contact("123-456"), new String[]{"Socks", "made of cotton", "demi-season"});

        System.out.println();
        System.out.println("convert socks object to a json string");
        final Gson socksGson = new GsonBuilder().create();
        System.out.println(socksGson.toJson(redSocks));

        System.out.println("Modifying json-string");
        String socksJson = "{\"isUniSex\":true, "
                + "\"cotton\":89.9,"
                + "\"color\":red,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"123-456\""
                + "},"
                + "\"characteristics\":"
                + "[\"Socks\",\"made of cotton\",\"demi-season\"]"
                + "}";
        final Socks socksMod = socksGson.fromJson(socksJson, Socks.class);
        System.out.println(socksMod);
    }
}