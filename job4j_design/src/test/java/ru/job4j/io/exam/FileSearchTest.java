package ru.job4j.io.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.job4j.io.ArgsName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FileSearchTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4"})
    @DisplayName("When invalid arguments then get exception")
    void searchFile(String directory, String fileName, String searchType, String target) {
        String[] args = {directory, fileName, searchType, target};
        assertThatIllegalArgumentException().isThrownBy(() -> ArgsName.of(args)).withMessage("Incorrect arguments");
    }
}