package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder numbers = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                numbers.append((char) read);
            }
            String[] lines = numbers.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (!line.isBlank()) {
                    System.out.printf("%s = %b%n", line, (Integer.parseInt(line) % 2 == 0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
