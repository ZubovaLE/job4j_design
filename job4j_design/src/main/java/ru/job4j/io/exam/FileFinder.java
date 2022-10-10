package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileFinder extends SimpleFileVisitor<Path> {
    private final String desiredFIle;
    private final String searchType;
    private String filePath = "File was not found";
    private final static String SEARCH_TYPE_IS_NAME = "name";
    private final static String SEARCH_TYPE_IS_MASK = "mask";
    private final static String SEARCH_TYPE_IS_REGEX = "regex";

    public FileFinder(String desiredFIle, String searchType) {
        this.desiredFIle = desiredFIle;
        this.searchType = searchType;
    }

    public String getFilePath() {
        return filePath;
    }

    private boolean getFilePathByRegex(String fileName) throws PatternSyntaxException {
        Pattern regexToSearchFile = Pattern.compile(desiredFIle);
        Matcher matcher = regexToSearchFile.matcher(fileName);
        return matcher.matches();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if ((searchType.equals(SEARCH_TYPE_IS_NAME) && file.toFile().getName().equals(desiredFIle))
                || (searchType.equals(SEARCH_TYPE_IS_MASK) && (file.toFile().getName().matches(desiredFIle)))
        || (searchType.equals(SEARCH_TYPE_IS_REGEX) && getFilePathByRegex(file.toFile().getName()))) {
            filePath = file.toFile().getAbsolutePath();
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return super.visitFile(file, attrs);
    }
}
