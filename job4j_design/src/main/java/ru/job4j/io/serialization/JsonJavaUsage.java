package ru.job4j.io.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonJavaUsage {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonPersonObject = new JSONObject();
        jsonPersonObject.put("sex", person.isSex());
        jsonPersonObject.put("age", person.getAge());
        jsonPersonObject.put("contact", jsonContact);
        jsonPersonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonPersonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person));

        JSONObject jsonSocksContact = new JSONObject("{\"phone\":\"123-456\"}");
        List<String> characteristics = new ArrayList<>();
        characteristics.add("socks");
        characteristics.add("made of cotton");
        characteristics.add("demi-season");
        JSONArray jsonCharacteristics = new JSONArray(characteristics);

        final Socks socks = new Socks(true, 89.9f, "red", new Contact("54-321"), "baby socks", "hypoallergenic");
        JSONObject jsonSocksObject = new JSONObject();
        jsonSocksObject.put("isUniSex", socks.isUniSex());
        jsonSocksObject.put("cotton", socks.getCotton());
        jsonSocksObject.put("color", socks.getColor());
        jsonSocksObject.put("contact", jsonSocksContact);
        jsonSocksObject.put("characteristics", jsonCharacteristics);
        System.out.println(jsonSocksObject);
        System.out.println(new JSONObject(socks));

    }
}

