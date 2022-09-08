package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private String directory;
    private String exclude;
    private String output;

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValid(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException();
        }
        ArgsName names = ArgsName.of(args);
        directory = names.get("d");
        exclude = names.get("e");
        output = names.get("o");
        if (isBlank(directory) && isBlank(exclude) || isBlank(output)) {
            throw new IllegalArgumentException();
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

    private void init(String[] args) throws IOException {
        Path start = Paths.get(directory);
        Path target = Paths.get(start.getParent() + File.separator + output);
        if (isValid(args)) {
            List<Path> files = Search.search(start, p -> p.toFile().getName().endsWith(exclude));
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

    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.packSingleFIle(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
