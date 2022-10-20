package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor extends SimpleFileVisitor<Path> {
    private int files = 0;
    private int folders = -1;
    private long totalSize = 0;

    public int getFiles() {
        return files;
    }

    public int getFolders() {
        return folders;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folders += 1;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files += 1;
        totalSize += attrs.size();
        return FileVisitResult.CONTINUE;
    }
}
