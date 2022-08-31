package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        int totalSize = 0;
        for (File subfile : file.listFiles()) {
            totalSize += (int) subfile.length();
            System.out.printf("name: %s, size: %d bytes%n", subfile.getAbsoluteFile(), subfile.length());
        }
        System.out.printf("Total size: %d bytes", totalSize);
    }
}
