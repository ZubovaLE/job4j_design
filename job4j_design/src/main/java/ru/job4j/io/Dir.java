package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Dir extends SimpleFileVisitor<Path> {
    int files = 0;
    int folders = -1;
    long sizeAll = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory())
            folders += 1;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files += 1;
        sizeAll += attrs.size();
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Dir fileVisitor = new Dir();
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subFile : file.listFiles()) {
            if (Files.isDirectory(Paths.get(subFile.getAbsolutePath()))) {
                Path subFilePath = Paths.get(subFile.getAbsolutePath());
                Files.walkFileTree(subFilePath, fileVisitor);
                System.out.printf("name %s, size: %d bytes%n", subFile.getAbsoluteFile(), fileVisitor.sizeAll);
            } else {
                System.out.printf("name %s, size: %d bytes%n", subFile.getAbsoluteFile(), subFile.length());
            }

        }
    }
}
