package ru.job4j.io.exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.job4j.io.ArgsName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class FileSearchTest {
    private static Path directory;
    private static Path file;
    private static Path outputFile;

    @BeforeAll
    static void init() throws IOException {
        directory = Files.createTempDirectory("directory");
        Path innerDirectory = Files.createTempDirectory(directory, "innerDirectory");
        file = Files.createTempFile(innerDirectory, "file", ".txt");
        outputFile = Files.createTempFile(directory, "outputFile", ".txt");
    }

    private static Stream<Arguments> provideParametrizedTestArguments() {
        String directoryPath = directory.toFile().getAbsolutePath();
        String fileName = file.getFileName().toString();
        return Stream.of(
                Arguments.of("-dir=di", "-n=" + fileName, "-t=name", "-o=out.txt", "No argument with directory"),
                Arguments.of("-d=" + directoryPath, "-name=fileName", "-t=name", "-o=out.txt", "No argument with file name"),
                Arguments.of("-d=" + directoryPath, "-n=" + fileName, "-type=name", "-o=out.txt", "No argument with search type"),
                Arguments.of("-d=" + directoryPath, "-n=" + fileName, "-t=name", "-out=out.txt", "No argument with target file name"),
                Arguments.of("-d=" + file, "-n=" + fileName, "-t=name", "-o=out.txt", "It is not a directory"),
                Arguments.of("-d=nonExistentDirectory", "-n=" + fileName, "-t=name", "-o=out.txt", "Directory does not exist"),
                Arguments.of("-d=" + directoryPath, "-n=" + fileName, "-t=type", "-o=out.txt", "Invalid searchType")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametrizedTestArguments")
    @DisplayName("When invalid arguments then get IllegalArgumentException")
    void searchFile(String directory, String fileName, String searchType, String target, String message) {
        String[] args = {directory, fileName, searchType, target};
        ArgsName argsname = ArgsName.of(args);
        assertThatIllegalArgumentException().isThrownBy(() -> FileSearch.searchFile(argsname)).withMessage(message);
    }

    @Test
    @DisplayName("Test searchFile when searchType is name")
    void testSearchFileWhenSearchByFileName() throws IOException {
        String[] args = {"-d=" + directory.toFile().getAbsolutePath(), "-n=" + file.getFileName().toString(), "-t=name", "-o=" + outputFile.toFile().getAbsolutePath()};
        FileSearch.searchFile(ArgsName.of(args));
        String expected = file.toFile().getAbsolutePath();
        assertThat(Files.readString(outputFile)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"f*.?xt, mask", "f.+\\.t.+,regex"})
    @DisplayName("Test searchFile when different searchTypes")
    void testSearchFileWhenDifferentSearchTypes(String fileName, String searchType) throws IOException {
        String[] args = {"-d=" + directory.toFile().getAbsolutePath(), "-n=" + fileName, "-t=" + searchType, "-o=" + outputFile.toFile().getAbsolutePath()};
        FileSearch.searchFile(ArgsName.of(args));
        String expected = file.toFile().getAbsolutePath();
        assertThat(Files.readString(outputFile)).isEqualTo(expected);
    }
}