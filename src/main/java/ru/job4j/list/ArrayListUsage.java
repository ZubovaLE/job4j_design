package ru.job4j.list;

import java.util.ArrayList;

public class ArrayListUsage {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String first = "first";
        String second = "second";
        String third = "third";
        list.add(first);
        list.add(second);
        list.add(third);
        System.out.println("Size is " + list.size());
        list.remove("first");
        System.out.println("Size after removing is " + list.size());
        list.clear();
        System.out.print("Size after clearing is " + list.size());
    }
}
