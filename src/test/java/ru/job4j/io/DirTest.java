package ru.job4j.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.*;

class DirTest {
    private static Path root;
    private static Path innerDirectory;
    private static Path firstFile;
    private static Path secondFile;
    private static Path thirdFile;
    private static Path fourthFile;

    @BeforeAll
    static void init() throws IOException {
        root = Files.createTempDirectory("directory");
        innerDirectory = Files.createTempDirectory(root, "innerDirectory");
        firstFile = Files.createTempFile(root, "firstFile", ".txt");
        secondFile = Files.createTempFile(innerDirectory, "secondFile", ".bmp");
        Path secondInnerDirectory = Files.createTempDirectory(innerDirectory, "innerDirectory");
        thirdFile = Files.createTempFile(secondInnerDirectory, "thirdFile", ".txt");
        fourthFile = Files.createTempFile(secondInnerDirectory, "fourthFile", ".txt");
    }

    @Test
    @DisplayName("Test getContentOfDirectory when valid root")
    void testGetContentOfDirectoryWhenValidRoot() throws IOException {
        List<String> result = Dir.getContentOfDirectory(new String[]{root.toFile().getAbsolutePath()});
        String expectedOne = String.format("%s is a directory:  total size = %d bytes, number of inner directories = 1, number of inner files = 3",
                innerDirectory.toFile().getName(), secondFile.toFile().length() + thirdFile.toFile().length() + fourthFile.toFile().length());
        String expectedTwo = String.format("%s is a file: size = %d bytes%n", firstFile.toFile().getName(), firstFile.toFile().length());
        assertThat(result).hasSize(2);
        assertThat(result).contains(expectedOne);
        assertThat(result).contains(expectedTwo);
    }

    @ParameterizedTest
    @MethodSource("provideParametrizedTestArguments")
    @DisplayName("Test getContentOfDirectory when invalid root then get IllegalArgumentException")
    void testGetContentOfDirectoryWhenInvalidRootThenGetException(String root, String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> Dir.getContentOfDirectory(new String[]{root}))
                .withMessage(message);
    }

    private static Stream<Arguments> provideParametrizedTestArguments() {
        String firstFilePath = firstFile.toFile().getAbsolutePath();
        String fileThatDoesNotExist = "does not exist";
        return Stream.of(
                Arguments.of(firstFilePath, String.format("Not directory %s", firstFilePath)),
                Arguments.of(fileThatDoesNotExist, String.format("Directory does not exist %s", new File(fileThatDoesNotExist).getAbsolutePath()))
        );
    }
}