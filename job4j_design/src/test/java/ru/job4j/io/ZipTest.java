package ru.job4j.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ZipTest {
    @ParameterizedTest
    @CsvSource(value = {"null,-e=.class,-o=project.zip",
            "-d=c:\\project\\job4j_design,null,-o=project.zip",
            "-d=c:\\project\\job4j_design,-e=.class,null",
            "d= ,-e=.class,-o=project.zip",
            "-d=c:\\project\\job4j_design,-e= ,-o=project.zip",
            "-d=c:\\project\\job4j_design,-e=.class,-o= "}, nullValues = "null")
    @DisplayName("Test Zip when invalid arguments then get IllegalArgumentException")
    void testZipWhenInvalidArgumentsThenGetIllegalArgumentException(String argOne, String argTwo, String argThree) {
        String[] args = {argOne, argTwo, argThree};
        Zip zip = new Zip();
        assertThatIllegalArgumentException().isThrownBy(() -> zip.init(args)).withMessage("Incorrect arguments");
    }

    @Test
    @DisplayName("Test Zip when invalid number of arguments then get IllegalArgumentException")
    void testZipWhenInvalidNumberOfArgumentsThenGetIllegalArgumentException() {
        String[] args = {"-d=c:\\project\\job4j_design", "-o=project.zip"};
        Zip zip = new Zip();
        assertThatIllegalArgumentException().isThrownBy(() -> zip.init(args)).withMessage("Invalid number of arguments");
    }

    @Test
    @DisplayName("Test Zip when directory doesn't exist then get IllegalArgumentException")
    void testZipWhenFileDoesNotExistThenGetIllegalArgumentException() {
        String[] args = {"-d=c:\\project\\doesNotExist", "-e=.class", "-o=project.zip"};
        Zip zip = new Zip();
        assertThatIllegalArgumentException().isThrownBy(() -> zip.init(args)).withMessage("Doesn't exist c:\\project\\doesNotExist");
    }
}