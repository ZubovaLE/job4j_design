package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        if (isRootValid(root)) {
            SearchFiles searcher = new SearchFiles(condition);
            Files.walkFileTree(root, searcher);
            return searcher.getPaths();
        }
        return List.of();
    }

    private static boolean isRootValid(Path root) {
        if (root == null) {
            throw new IllegalArgumentException("Root was not found");
        } else if (Files.notExists(root, LinkOption.NOFOLLOW_LINKS)) {
            throw new IllegalArgumentException("Root does not exist");
        } else if (!Files.isDirectory(root, LinkOption.NOFOLLOW_LINKS)) {
            throw new IllegalArgumentException("Root is not a directory");
        }
        return true;
    }
}
