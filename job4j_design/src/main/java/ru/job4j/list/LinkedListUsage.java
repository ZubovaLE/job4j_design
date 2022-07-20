package ru.job4j.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LinkedListUsage {
    public static void main(String[] args) {
        LinkedList<String> listOfStrings = new LinkedList<>();
        listOfStrings.add("first");
        listOfStrings.add("second");
        listOfStrings.add("third");
        System.out.print("An initial version of the list: ");
        System.out.println(listOfStrings);
        listOfStrings.add(1, "new");
        System.out.print("The list after changing: ");
        System.out.println(listOfStrings);

        System.out.print("Does the element with index = 2 have a previous element? ");
        System.out.println(listOfStrings.listIterator(2).hasPrevious());
        System.out.print("This previous element is: ");
        System.out.println(listOfStrings.listIterator(2).previous());

        listOfStrings.set(listOfStrings.lastIndexOf("third"), "instead of third");
        System.out.println("A new version of the list: ");
        System.out.println(listOfStrings);
        System.out.print("Does the list contains a 'third' element? ");
        System.out.println(listOfStrings.contains("third"));

        System.out.print("The first element is: ");
        System.out.println(listOfStrings.peek());
        System.out.print("The last element is: ");
        System.out.println(listOfStrings.peekLast());
    }
}
