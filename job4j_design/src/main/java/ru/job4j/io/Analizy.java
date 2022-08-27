package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean unavailable = false;
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target));
             BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line = read.readLine();
            while (line != null) {
                if (!line.isBlank()) {
                    String[] data = line.split(" ");
                    if (!unavailable && (data[0].equals("400") || data[0].equals("500"))) {
                        out.print(data[1]);
                        unavailable = true;
                    } else if (unavailable && !(data[0].equals("400") || data[0].equals("500"))) {
                        out.print(";" + data[1] + System.lineSeparator());
                        unavailable = false;
                    }
                }
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/source.csv", "./data/target.csv");
        new Analizy().unavailable("./data/second_source.csv", "./data/second_target.csv");
    }
}
