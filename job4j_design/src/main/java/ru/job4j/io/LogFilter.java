package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        String[] words;
        List<String> lines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
                words = line.split(" ");
                if (words[words.length - 2].equals("404")) {
                    lines.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);
    }
}
