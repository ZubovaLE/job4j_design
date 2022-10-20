package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class SetUsage {
    public static void show(Set<String> set) {
        for (String x : set) {
            System.out.print(x + ":");
        }
    }

    public static void main(String[] args) {
        Set<String> setOfStrings = new HashSet<>(Set.of("one", "two", "three"));
        System.out.println("Was 'four' added? " + setOfStrings.add("four"));
        System.out.println("Was a duplicate added? " + setOfStrings.add("one"));
        show(setOfStrings);
        System.out.println("\nWere the elements added to the set? " + setOfStrings.addAll(Set.of("one", "five", "zero")));
        show(setOfStrings);
        System.out.println("\nWas 'zero' removed? " + setOfStrings.remove("zero"));
        show(setOfStrings);
        System.out.println("\nWere the elements removed? " + setOfStrings.removeAll(Set.of("zero", "four")));
        show(setOfStrings);
        System.out.println("\nWas the set changed? " + setOfStrings.retainAll(Set.of("one", "two", "five")));
        show(setOfStrings);
        System.out.println("\nWas the set changed? " + setOfStrings.removeIf(s -> s.contains("o")));
        show(setOfStrings);
        System.out.println("The set contains 'five': " + setOfStrings.contains("five"));
        System.out.println("Size: " + setOfStrings.size());
    }
}
