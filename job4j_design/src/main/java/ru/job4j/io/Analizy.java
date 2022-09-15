package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

public class Analizy {
    private final static String LINE_DELIMITER = " ";
    private final static List<String> DOWNTIME_STATUSES = List.of("400", "500");

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
                        if (!stopWorking && isDowntimeStatus(status)) {
                            out.print(time);
                            stopWorking = true;
                        } else if (stopWorking && !isDowntimeStatus(status)) {
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

    private boolean isDowntimeStatus(String status) {
        return DOWNTIME_STATUSES.contains(status);
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/source.csv", "./data/target.csv");
        new Analizy().unavailable("./data/second_source.csv", "./data/second_target.csv");
    }
}
