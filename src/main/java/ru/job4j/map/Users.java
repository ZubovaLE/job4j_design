package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Users  {
    public static void main(String[] args) {
        String name = "Anna";
        int children = 2;
        Calendar birth = new GregorianCalendar(1975, Calendar.JANUARY, 12);

        Map<User, Object> mapOfUsers = new HashMap<>();

        User first = new User(name, children, birth);
        User second = new User(name, children, birth);
        mapOfUsers.put(first, new Object());
        mapOfUsers.put(second, new Object());
        System.out.println(mapOfUsers);

        first = new UserWithHashCode(name, children, birth);
        second = new UserWithHashCode(name, children, birth);
        mapOfUsers = new HashMap<>();
        mapOfUsers.put(first, new Object());
        mapOfUsers.put(second, new Object());
        System.out.println();
        System.out.println(mapOfUsers);

        first = new UserWithEquals(name, children, birth);
        second = new UserWithEquals(name, children, birth);
        mapOfUsers = new HashMap<>();
        mapOfUsers.put(first, new Object());
        mapOfUsers.put(second, new Object());
        System.out.println();
        System.out.println(mapOfUsers);

        first = new UserWithEqualsAndHashCode(name, children, birth);
        second = new UserWithEqualsAndHashCode(name, children, birth);
        mapOfUsers = new HashMap<>();
        mapOfUsers.put(first, new Object());
        mapOfUsers.put(second, new Object());
        System.out.println();
        System.out.println(mapOfUsers);
    }

}
