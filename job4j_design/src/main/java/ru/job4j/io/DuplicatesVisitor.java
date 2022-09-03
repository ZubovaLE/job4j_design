package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> pathsOfDuplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty newFile = new FileProperty(attrs.size(), file.toFile().getName());
        if (pathsOfDuplicates.containsKey(newFile)) {
            pathsOfDuplicates.get(newFile).add(file);
        } else {
            List<Path> paths = new ArrayList<>();
            paths.add(file);
            pathsOfDuplicates.put(newFile, paths);
        }
        return super.visitFile(file, attrs);
    }

    public void getDuplicates() {
        pathsOfDuplicates.entrySet().stream()
                .filter(p -> p.getValue().size() > 1)
                .flatMap(e -> e.getValue().stream())
                .forEach(file -> System.out.println(file.toAbsolutePath()));
    }
}
