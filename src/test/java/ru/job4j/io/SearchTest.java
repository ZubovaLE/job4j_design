package ru.job4j.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class SearchTest {
    static private Path root;
    static private Path firstFile;
    static private Path secondFile;
    static private Path thirdFile;
    static private Path fourthFile;
    static private Predicate<Path> condition;

    @BeforeAll
    static void init() throws IOException {
        root = Files.createTempDirectory("directory");
        Path innerDirectory = Files.createTempDirectory(root, "innerDirectory");
        firstFile = Files.createTempFile(innerDirectory, "firstFile", ".txt");
        secondFile = Files.createTempFile(root, "secondFile", ".bmp");
        thirdFile = Files.createTempFile(innerDirectory, "thirdFile", ".txt");
        fourthFile = Files.createTempFile(root, "fourthFile", ".txt");
        condition = p -> p.toFile().getName().endsWith(".txt");
    }

    @Test
    @DisplayName("Try to find files with .txt")
    void testSearch() throws IOException {
        Predicate<Path> condition = p -> p.toFile().getName().endsWith(".txt");
        List<Path> result = Search.search(root, condition);
        assertThat(result).hasSize(3);
        assertThat(result).doesNotContain(secondFile);
        assertThat(result).containsAll(List.of(firstFile, thirdFile, fourthFile));
    }

    @ParameterizedTest
    @MethodSource("provideParametrizedTestArguments")
    @DisplayName("Test search when invalid root then get IllegalArgumentException")
    void testSearchWhenInvalidRootThenGetException(Path root, String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> Search.search(root, condition)).withMessage(message);
    }

    private static Stream<Arguments> provideParametrizedTestArguments() {
        return Stream.of(
                Arguments.of(null, "Root was not found"),
                Arguments.of(Paths.get("does not exist"), "Root does not exist"),
                Arguments.of(firstFile, "Root is not a directory")
        );
    }
}