package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    private final static String LINE_DELIMITER = " ";

    public void unavailable(String source, String target) {
        boolean stopWorking = false;
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target));
             BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line = read.readLine();
            String status;
            String time;
            while (line != null) {
                if (!line.isBlank()) {
                    String[] data = line.split(LINE_DELIMITER);
                    if (data.length == 2) {
                        status = data[0];
                        time = data[1];
                        if (!stopWorking && downtimeStatus(status)) {
                            out.print(time);
                            stopWorking = true;
                        } else if (stopWorking && !downtimeStatus(status)) {
                            StringBuilder info = new StringBuilder();
                            out.print(info.append(";").append(time).append(System.lineSeparator()));
                            stopWorking = false;
                        }
                    }
                }
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean downtimeStatus(String status) {
        return status.equals("400") || status.equals("500");
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/source.csv", "./data/target.csv");
        new Analizy().unavailable("./data/second_source.csv", "./data/second_target.csv");
    }
}
