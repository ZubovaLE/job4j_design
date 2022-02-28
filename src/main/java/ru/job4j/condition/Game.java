package ru.job4j.condition;

public class Game {
    public static void main(String[] args) {
        menu("tanks");
        menu("Civilization");
    }

    public static void menu(String name) {
        if ("SuperMario".equals(name)) {
            System.out.println("Start - Super Mario");
        } else if ("tanks".equals(name)) {
            System.out.println("Start - tanks");
        } else if ("tetris".equals(name)) {
            System.out.println("Start - tetris");
        } else {
            System.out.println("The game is not found");
        }
    }
}
