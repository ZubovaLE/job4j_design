package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.nio.file.Paths;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CSVReader {
    private final static String PATH = "path";
    private final static String DELIMITER = "delimiter";
    private final static String OUT = "out";
    private final static String FILTER = "filter";
    private final static String FILTER_DELIMITER = ",";

    public static void handle(ArgsName argsName) {
        String path = argsName.get(PATH);
        String delimiter = argsName.get(DELIMITER);
        String out = argsName.get(OUT);
        String filter = argsName.get(FILTER);
        String[] tableElements;
        if (isValid(path, delimiter, out, filter)) {
            Optional<List<String>> filters = getListOfFilters(filter);
            try (var scanner = new Scanner(path)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    tableElements = line.split(delimiter);
                }
            }
        }
    }

    private static boolean isValid(String path, String delimiter, String out, String filter) {
        return isNotBlank(path) && Paths.get(path).toFile().exists() && isNotBlank(delimiter) && isNotBlank(out) && isNotBlank(filter);
    }

    private static Optional<List<String>> getListOfFilters(String stringOfFilters) {
        return Optional.of(Arrays.stream(stringOfFilters.split(FILTER_DELIMITER)).toList());
    }

    private String createString(List<String> filters, String line, String delimiter, String out) {
        String result = "";
        return result;
    }
}
