package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFinder extends SimpleFileVisitor<Path> {
    private final String desiredFIle;
    private final String SEARCH_TYPE;
    private String filePath = "File was not found";
    private final String SEARCH_TYPE_IS_NAME = "name";
    private final String SEARCH_TYPE_IS_MASK = "mask";

    public FileFinder(String desiredFIle, String SEARCH_TYPE) {
        this.desiredFIle = desiredFIle;
        this.SEARCH_TYPE = SEARCH_TYPE;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if ((SEARCH_TYPE.equals(SEARCH_TYPE_IS_NAME) && file.toFile().getName().equals(desiredFIle))
                || (SEARCH_TYPE.equals(SEARCH_TYPE_IS_MASK) && (file.toFile().getName().matches(desiredFIle)))) {
            filePath = file.toFile().getAbsolutePath();
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return super.visitFile(file, attrs);
    }
}
