package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static final int VALID_NUMBER_OF_ARGS = 3;
    private String directory;
    private String exclude;
    private String output;
    private final List<File> filesForPacking = new ArrayList<>();

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                if (!file.isDirectory()) {
                    packSingleFIle(file, target);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFIle(File source, File target) {
        if (source.exists()) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValid(String[] args) throws IllegalArgumentException{
        if (args.length != VALID_NUMBER_OF_ARGS) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        ArgsName names = ArgsName.of(args);
        directory = names.get("d");
        exclude = names.get("e");
        output = names.get("o");
        if (isBlank(directory) || isBlank(exclude) || isBlank(output)) {
            throw new IllegalArgumentException("Incorrect arguments");
        }
        File source = new File(directory);
        if (!source.exists()) {
            throw new IllegalArgumentException(String.format("Doesn't exist %s", source.getAbsoluteFile()));
        }
        if (!source.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", source.getAbsoluteFile()));
        }
        return true;
    }

    public void init(String[] args) throws IOException {
        if (isValid(args)) {
            Path start = Paths.get(directory);
            File target = new File(output);
            List<Path> files = Search.search(start, p -> !p.toFile().getName().endsWith(exclude));
            for (Path file : files) {
                filesForPacking.add(file.toFile());
            }
            packFiles(filesForPacking, target);
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.init(args);
    }
}
