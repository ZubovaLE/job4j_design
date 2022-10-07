package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFinder extends SimpleFileVisitor<Path> {
    private final Path desiredFIle;
    private String filePath = "File was not found";

    public FileFinder(Path desiredFile) {
        this.desiredFIle = desiredFile;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().equals(desiredFIle.getFileName())) {
            filePath = file.toAbsolutePath().toString();
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return super.visitFile(file, attrs);
    }
}
