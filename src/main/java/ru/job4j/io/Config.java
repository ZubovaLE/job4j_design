package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line;
            String[] keysAndValues;
            while (read.ready()) {
                line = read.readLine();
                if (isBlank(line) || line.contains("#")) {
                    continue;
                }
                if (line.split("=").length == 2) {
                    keysAndValues = line.split("=");
                    values.put(keysAndValues[0], keysAndValues[1]);
                    continue;
                }
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
