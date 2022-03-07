package ru.job4j.loop;

public class Slash {
    public static void draw(int size) {
        if (size % 2 != 0) {
            System.out.printf("Cross of size %d x %d%n", size, size);
            for (int row = 0; row < size; row++) {
                for (int cell = 0; cell < size; cell++) {
                    boolean left = row == cell;
                    boolean right = row + cell == size - 1;
                    if (left || right) {
                        System.out.print("0");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        } else {
            System.out.println("Error. The number is even. Cross can't be drawn\n");
        }
    }

    public static void main(String[] args) {
        draw(3);
        draw(4);
        draw(5);
        draw(7);
    }
}
