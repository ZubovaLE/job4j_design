package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ListUsage<T> {
    private final List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public void addElement(T el) {
        list.add(el);
    }

    public void addElementToCertainPosition(int position, T el) {
        if (position < list.size() && position >= 0) {
            list.add(position, el);
        }
    }

    public boolean addElementsFromCollection(List<T> elements) {
        return list.addAll(elements);
    }

    public boolean addElementsFromCollectionToCertainPosition(int position, List<T> elements) {
        boolean result = false;
        if (position < elements.size() && position >= 0) {
            result = list.addAll(position, elements);
        }
        return result;
    }

    public void showElements() {
        for (T el : list) {
            System.out.println("Текущий элемент: " + el);
        }
    }

    public void showElementsFromCertainPosition(int position) {
        if (position < list.size() && position >= 0) {
            ListIterator<T> iterator = list.listIterator(position);
            while (iterator.hasNext()) {
                System.out.println("Текущий элемент: " + iterator.next());
            }
        }
    }

    public T getElement(int position) {
        if (position < list.size() && position >= 0) {
            return list.get(position);
        }
        return null;
    }

    public T changeElement(int position, T el) {
        if (position < list.size() && position >= 0) {
            return list.set(position, el);
        }
        return null;
    }

    public void replaceAllElements(UnaryOperator<T> operator) {
        list.replaceAll(operator);
    }

    public void removeElement(int position) {
        if (position < list.size() && position >= 0) {
            System.out.println("The element  " + list.remove(position) + " was successfully deleted");
        }
    }

    public boolean removeCertainElement(T el) {
        return list.remove(el);
    }

    public boolean removeAllElements(List<T> elements) {
        return list.removeAll(elements);
    }

    public boolean retainElements(List<T> elements) {
        return list.retainAll(elements);
    }

    public boolean removeElementIf(Predicate<T> predict) {
        return list.removeIf(predict);
    }

    public boolean checkIfContains(T el) {
        return list.contains(el);
    }

    public int findElement(T el) {
        return list.indexOf(el);
    }

    public int returnSize() {
        return list.size();
    }

    public static void main(String[] args) {
        ListUsage<String> listOfStrings = new ListUsage<>();
        listOfStrings.addElement("one");
        listOfStrings.addElement("three");
        listOfStrings.addElement("four");
        listOfStrings.addElementToCertainPosition(1, "two");

        List<String> newList = List.of("five", "six");
        listOfStrings.addElementsFromCollection(newList);

        List<String> secondList = new ArrayList<>();
        secondList.add("zero");
        listOfStrings.addElementsFromCollectionToCertainPosition(0, secondList);
        listOfStrings.showElementsFromCertainPosition(3);
        System.out.println(listOfStrings.getElement(4));
        listOfStrings.changeElement(3, "anotherThree");
        listOfStrings.showElementsFromCertainPosition(3);
        listOfStrings.replaceAllElements(String::toUpperCase);
        listOfStrings.showElements();
        listOfStrings.removeElement(6);
        listOfStrings.showElementsFromCertainPosition(4);
        listOfStrings.removeCertainElement("FOUR");
        listOfStrings.showElementsFromCertainPosition(3);
    }
}
