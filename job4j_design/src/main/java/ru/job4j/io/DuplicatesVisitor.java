package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> pathsOfDuplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty newFile = new FileProperty(attrs.size(), file.toFile().getName());
        pathsOfDuplicates.merge(newFile, createListOfPaths(file), (file1, file2) -> {
            file1.addAll(file2);
            return file1;
        });
        return super.visitFile(file, attrs);
    }

    private List<Path> createListOfPaths(Path file) {
        List<Path> paths = new ArrayList<>();
        paths.add(file);
        return paths;
    }

    public void getDuplicates() {
        pathsOfDuplicates.entrySet().stream()
                .filter(p -> p.getValue().size() > 1)
                .flatMap(e -> e.getValue().stream())
                .forEach(file -> System.out.println(file.toAbsolutePath()));
    }
}
