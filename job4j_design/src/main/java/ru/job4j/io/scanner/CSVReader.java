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
    private final static String LINE_SEPARATOR = System.lineSeparator();

    public static void handle(ArgsName argsName) throws IOException {
        String path = argsName.get(PATH);
        String delimiter = argsName.get(DELIMITER);
        String out = argsName.get(OUT);
        String filter = argsName.get(FILTER);
        String line;
        String outputInfo;
        List<String> listOfFilters;
        List<Integer> appropriateIndexes;
        if (isValid(path, delimiter, out, filter)) {
            Optional<List<String>> filters = getListOfFilters(filter);
            try (var scanner = new Scanner(Paths.get(path)).useDelimiter(LINE_SEPARATOR)) {
                if (scanner.hasNext() && filters.isPresent()) {
                    line = scanner.next();
                    listOfFilters = filters.get();
                    appropriateIndexes = getAppropriateIndexes(line, delimiter, listOfFilters);
                    outputInfo = createString(line, delimiter, appropriateIndexes);
                    writeInfoToDataReceiver(out, outputInfo);
                    while (scanner.hasNext()) {
                        line = scanner.next();
                        outputInfo = createString(line, delimiter, appropriateIndexes);
                        writeInfoToDataReceiver(out, outputInfo);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Arguments are invalid. Enter correct arguments.");
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

    private static String createString(String line, String delimiter, List<Integer> indexes) {
        List<String> tableElements = Arrays.asList(line.split(delimiter));
        StringBuilder outputString = new StringBuilder();
        if (tableElements.size() >= indexes.size()) {
            for (Integer index : indexes) {
                outputString.append(tableElements.get(index)).append(delimiter);
            }
            outputString.deleteCharAt(outputString.length() - 1);
            outputString.append(LINE_SEPARATOR);
        }
        return outputString.toString();
    }

    private static void writeInfoToDataReceiver(String out, String info) {
        if (out.equals(STDOUT)) {
            System.out.print(info);
        } else {
            try (PrintWriter writeInfo = new PrintWriter(new FileWriter(out, true))) {
                writeInfo.print(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
