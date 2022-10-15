package ru.job4j.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private static Stream<Path> provideParametrizedTestArguments() {
        return Stream.of(null, firstFile);
    }

    @Test
    void testSearch() throws IOException {
        Predicate<Path> condition = p -> p.toFile().getName().endsWith(".txt");
        List<Path> result = Search.search(root, condition);
        assertThat(result).hasSize(3);
        assertThat(result).doesNotContain(secondFile);
        assertThat(result).containsAll(List.of(firstFile, thirdFile, fourthFile));
    }

    @ParameterizedTest
    @MethodSource("provideParametrizedTestArguments")
    void testSearchWhenRootIsNotDirectoryThenGetException(Path dir) {
        assertThatIllegalArgumentException().isThrownBy(() -> Search.search(dir, condition)).withMessage("Invalid root");
    }
}