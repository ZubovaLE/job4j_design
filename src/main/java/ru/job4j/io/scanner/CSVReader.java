package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        String stringOfFilters = argsName.get(FILTER);

        String line;
        String outputInfo;
        List<String> listOfLineElements;
        Map<String, Integer> appropriateIndexes;

        if (isValid(path, delimiter, out, stringOfFilters)) {
            List<String> listOfFilters = getListOfFilters(stringOfFilters);
            try (var scanner = new Scanner(Paths.get(path)).useDelimiter(LINE_SEPARATOR)) {
                if (scanner.hasNext() && !listOfFilters.isEmpty()) {
                    line = scanner.next();
                    listOfLineElements = getListOfLineElements(line, delimiter);
                    appropriateIndexes = getAppropriateIndexes(listOfLineElements, listOfFilters);
                    outputInfo = generateOutputString(listOfLineElements, appropriateIndexes, delimiter);
                    writeInfoToDataReceiver(out, outputInfo);
                    while (scanner.hasNext()) {
                        line = scanner.next();
                        listOfLineElements = getListOfLineElements(line, delimiter);
                        outputInfo = generateOutputString(listOfLineElements, appropriateIndexes, delimiter);
                        writeInfoToDataReceiver(out, outputInfo);
                    }
                } else {
                    throw new IllegalArgumentException("Input correct filters!");
                }
            }
        } else {
            throw new IllegalArgumentException("Arguments are invalid. Enter correct arguments.");
        }
    }

    private static boolean isValid(String path, String delimiter, String out, String filter) {
        return isNotBlank(path) && new File(path).exists()
                && isNotBlank(delimiter) && isNotBlank(out)
                && isNotBlank(filter);
    }

    private static List<String> getListOfFilters(String stringOfFilters) {
        return Arrays.stream(stringOfFilters.split(FILTER_DELIMITER)).toList();
    }

    private static Map<String, Integer> getAppropriateIndexes(List<String> lineElements, List<String> filters) {
        return lineElements.size() >= filters.size() ? filters.stream()
                .collect(Collectors.toMap(Function.identity(), lineElements::indexOf)) : Map.of();
    }

    private static String generateOutputString(List<String> lineElements, Map<String, Integer> indexes, String delimiter) {
        StringBuilder outputString = new StringBuilder();
        if (lineElements.size() >= indexes.size()) {
            for (Map.Entry<String, Integer> entry : indexes.entrySet()) {
                outputString.append(lineElements.get(entry.getValue())).append(delimiter);
            }
            outputString.deleteCharAt(outputString.length() - 1);
            outputString.append(LINE_SEPARATOR);
        } else {
            throw new IllegalArgumentException("The CSV file is incorrect");
        }
        return outputString.toString();
    }

    private static List<String> getListOfLineElements(String line, String delimiter) {
        return Arrays.asList(line.split(delimiter));
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
