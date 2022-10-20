package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final static String DELIMITER_LINE = " ";

    public static List<String> filter(String file) {
        List<String> lines = null;
        if (!isBlank(file)) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
                lines = buffer.lines()
                        .filter(line -> {
                            String[] words = line.split(DELIMITER_LINE);
                            return words[words.length - 2].equals("404");
                        })
                        .collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        if (!isBlank(file)) {
            File targetFile = new File(file);
            if (targetFile.exists()) {
                try (FileWriter addInfo = new FileWriter(file, true)) {
                    for (String line : log) {
                        addInfo.write(line + System.lineSeparator());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try (PrintWriter out = new PrintWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(file)
                        ))) {
                    out.println(log);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> firstLog = filter("log.txt");
        save(firstLog, "404.txt");
    }
}
