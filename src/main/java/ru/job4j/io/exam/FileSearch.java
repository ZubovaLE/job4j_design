package ru.job4j.io.exam;

import static org.apache.commons.lang3.StringUtils.isBlank;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileSearch {
    private static final String DIRECTORY = "d";
    private static final String FILE_NAME = "n";
    private static final String SEARCH_TYPE = "t";
    private static final String TARGET = "o";
    private static final List<String> SEARCH_TYPES = List.of("name", "mask", "regex");

    public static void searchFile(ArgsName argsname) throws IOException {
        String directory = argsname.get(DIRECTORY);
        String fileName = argsname.get(FILE_NAME);
        String searchType = argsname.get(SEARCH_TYPE);
        String target = argsname.get(TARGET);
        if (isArgumentsValid(directory, searchType, fileName, target)) {
            FileFinder finder = new FileFinder(fileName, searchType);
            Files.walkFileTree(Paths.get(directory), finder);
            try (FileWriter out = new FileWriter(target)) {
                out.write(finder.getFilePath());
            }
        }
    }

    private static boolean isArgumentsValid(String directory, String searchType, String fileName, String target) {
        if (isBlank(fileName)) {
            throw new IllegalArgumentException("No argument with file name");
        } else if (isBlank(target)) {
            throw new IllegalArgumentException("No argument with target file name");
        }
        return isDirectoryValid(directory)
                && isSearchTypeValid(searchType);
    }

    private static boolean isDirectoryValid(String directory) {
        if (isBlank(directory)) {
            throw new IllegalArgumentException("No argument with directory");
        }
        File dir = new File(directory);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Directory does not exist");
        } else if (!dir.isDirectory()) {
            throw new IllegalArgumentException("It is not a directory");
        }
        return true;
    }

    private static boolean isSearchTypeValid(String searchType) {
        if (isBlank(searchType)) {
            throw new IllegalArgumentException("No argument with search type");
        } else if (!SEARCH_TYPES.contains(searchType)) {
            throw new IllegalArgumentException("Invalid searchType");
        }
        return true;
    }
}
