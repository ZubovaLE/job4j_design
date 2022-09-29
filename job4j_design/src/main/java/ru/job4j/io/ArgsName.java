package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        int position;
        for (String pair : args) {
            if (!isValid(pair)) {
                throw new IllegalArgumentException("Incorrect arguments");
            }
            position = pair.indexOf("=");
            values.put(pair.substring(1, position), pair.substring(position + 1));
        }
    }

    private static boolean isValid(String line) {
        return isNotBlank(line) && line.contains("=") && line.startsWith("-")
                && line.indexOf("=") != 0 && line.indexOf("=") != line.length() - 1;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
