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

        User first = new User(name, children, birth);
        User second = new User(name, children, birth);
        Map<User, Object> mapForUsers = new HashMap<>();
        mapForUsers.put(first, new Object());
        mapForUsers.put(second, new Object());
        System.out.println(mapForUsers);

        UserWithHashCode firstWithHash = new UserWithHashCode(name, children, birth);
        UserWithHashCode secondWithHash = new UserWithHashCode(name, children, birth);
        Map<UserWithHashCode, Object> mapForUsersWithHashCOde = new HashMap<>();
        mapForUsersWithHashCOde.put(firstWithHash, new Object());
        mapForUsersWithHashCOde.put(secondWithHash, new Object());
        System.out.println();
        System.out.println(mapForUsersWithHashCOde);

        UserWithEquals firstWithEquals = new UserWithEquals(name, children, birth);
        UserWithEquals secondWithEquals = new UserWithEquals(name, children, birth);
        Map<UserWithEquals, Object> mapForUsersWithEquals = new HashMap<>();
        mapForUsersWithEquals.put(firstWithEquals, new Object());
        mapForUsersWithEquals.put(secondWithEquals, new Object());
        System.out.println();
        System.out.println(mapForUsersWithEquals);

        UserWithEqualsAndHashCode firstWithBothMethods = new UserWithEqualsAndHashCode(name, children, birth);
        UserWithEqualsAndHashCode secondWithBothMethods = new UserWithEqualsAndHashCode(name, children, birth);
        Map<UserWithEqualsAndHashCode, Object> mapForUsersWithBothMethods = new HashMap<>();
        mapForUsersWithBothMethods.put(firstWithBothMethods, new Object());
        mapForUsersWithBothMethods.put(secondWithBothMethods, new Object());
        System.out.println();
        System.out.println(mapForUsersWithBothMethods);
    }

}
