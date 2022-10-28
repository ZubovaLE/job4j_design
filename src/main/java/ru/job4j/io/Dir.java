package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dir extends SimpleFileVisitor<Path> {
    public static List<String> getContentOfDirectory(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is not found");
        }
        List<String> infoList = new ArrayList<>();
        Visitor fileVisitor = new Visitor();
        File rootDirectory = new File(args[0]);
        if (isDirectoryValid(rootDirectory)) {
            for (File subFile : Objects.requireNonNull(rootDirectory.listFiles())) {
                if (subFile.isDirectory()) {
                    Files.walkFileTree(Paths.get(subFile.getAbsolutePath()), fileVisitor);
                    infoList.add(String.format("%s is a directory:  total size = %d bytes, number of inner directories = %d, number of inner files = %d",
                            subFile.getName(), fileVisitor.getTotalSize(), fileVisitor.getFolders(), fileVisitor.getFiles()));
                } else {
                    infoList.add(String.format("%s is a file: size = %d bytes%n", subFile.getName(), subFile.length()));
                }
            }
        }
        return infoList;
    }

    private static boolean isDirectoryValid(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Directory does not exist %s", file.getAbsolutePath()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsolutePath()));
        }
        return true;
    }
}
