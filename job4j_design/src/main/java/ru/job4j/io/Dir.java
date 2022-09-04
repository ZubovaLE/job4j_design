package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

public class Dir extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER");
        }
        Visitor fileVisitor = new Visitor();
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subFile : Objects.requireNonNull(file.listFiles())) {
            if (subFile.isDirectory()) {
                Files.walkFileTree(Paths.get(subFile.getAbsolutePath()), fileVisitor);
                System.out.printf("name: %s, folders: %d, files: %d, total size: %d bytes%n",
                        subFile.getAbsoluteFile(), fileVisitor.getFolders(), fileVisitor.getFiles(), fileVisitor.getTotalSize());
            } else {
                System.out.printf("name %s, size: %d bytes%n", subFile.getName(), subFile.length());
            }
        }
    }
}
