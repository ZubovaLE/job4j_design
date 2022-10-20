package ru.job4j.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class VisitorTest {
    private Path directory;

    @BeforeEach
    public void init() throws IOException {
        directory = Files.createTempDirectory("directory");
        Path firstInnerDirectory = Files.createTempDirectory(directory, "firstInnerDirectory");
        Path secondInnerDirectory = Files.createTempDirectory(firstInnerDirectory, "secondInnerDirectory");
        Path firstFile = Files.createTempFile(directory, "firstFile", ".txt");
        Path secondFile = Files.createTempFile(firstInnerDirectory, "secondFile", ".txt");
        Path thirdFile = Files.createTempFile(secondInnerDirectory, "thirdFile", ".txt");
    }

    @Test
    @DisplayName("Test visitor when 2 directories and 3 files")
    void testVisitorWhen2DirectoriesAnd3Files() throws IOException {
        Visitor visitor = new Visitor();
        Files.walkFileTree(directory, visitor);
        assertThat(visitor.getFolders()).isEqualTo(2);
        assertThat(visitor.getFiles()).isEqualTo(3);
    }
}