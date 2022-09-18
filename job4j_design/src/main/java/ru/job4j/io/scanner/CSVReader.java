package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CSVReader {
    private final static String PATH = "path";
    private final static String DELIMITER = "delimiter";
    private final static String OUT = "out";
    private final static String FILTER = "filter";
    private final static String FILTER_DELIMITER = ",";
    private final static String STDOUT = "stdout";

    public static void handle(ArgsName argsName) {
        String path = argsName.get(PATH);
        String delimiter = argsName.get(DELIMITER);
        String out = argsName.get(OUT);
        String filter = argsName.get(FILTER);
        String line;
        List<String> listOfFilters;
        List<Integer> appropriateIndexes;
        if (isValid(path, delimiter, out, filter)) {
            Optional<List<String>> filters = getListOfFilters(filter);
            try (var scanner = new Scanner(path).useDelimiter(System.lineSeparator())) {
                if (scanner.hasNext() && filters.isPresent()) {
                    line = scanner.nextLine();
                    listOfFilters = filters.get();
                    appropriateIndexes = getAppropriateIndexes(line, delimiter, listOfFilters);
                    while (scanner.hasNext()) {
                        line = scanner.nextLine();
                        createString(out, line, delimiter, appropriateIndexes);
                    }
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

    private static List<Integer> getAppropriateIndexes(String line, String delimiter, List<String> filters) {
        List<String> tableElements = Arrays.asList(line.split(delimiter));
        List<Integer> indexesOfAppropriateElements = new ArrayList<>();
        for (String filter : filters) {
            indexesOfAppropriateElements.add(tableElements.indexOf(filter));
        }
        return indexesOfAppropriateElements;
    }

    private static String createString(String out, String line, String delimiter, List<Integer> indexes) {
        List<String> tableElements = Arrays.asList(line.split(delimiter));
        StringBuilder outputString = new StringBuilder();
        for (Integer index : indexes) {
            outputString.append(tableElements.get(index)).append(delimiter);
        }
        if (out.equals(STDOUT)) {
            System.out.println(outputString);
        } else {
            File outputFile = new File(out);
        }
        return outputString.toString();
    }
}
