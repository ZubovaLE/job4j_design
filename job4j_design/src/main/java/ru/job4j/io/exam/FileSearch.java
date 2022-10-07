package ru.job4j.io.exam;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSearch {
    private static final String DIRECTORY = "d";
    private static final String FILE_NAME = "n";
    private static final String SEARCH_TYPE = "t";
    private static final String TARGET = "o";

    public static void searchFile(ArgsName argsname) throws IOException {
        String directory = argsname.get(DIRECTORY);
        String file = argsname.get(FILE_NAME);
        String searchType = argsname.get(SEARCH_TYPE);
        String target = argsname.get(TARGET);
        if (isValid(directory, file, searchType, target)) {
            FileFinder finder = new FileFinder(Paths.get(file));
            Files.walkFileTree(Paths.get(directory), finder);
            System.out.println(finder.getFilePath());
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }
    }

    private static boolean isValid(String directory, String file, String searchType, String target) {
        return isNotBlank(directory) && new File(directory).exists()
                && new File(directory).isDirectory() && isNotBlank(file)
                && isNotBlank(searchType) && isNotBlank(target);
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsname = ArgsName.of(args);
        searchFile(argsname);
    }
}
