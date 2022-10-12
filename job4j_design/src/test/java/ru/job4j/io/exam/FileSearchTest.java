package ru.job4j.io.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.job4j.io.ArgsName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class FileSearchTest {
    @ParameterizedTest
    @CsvSource(value = {"-dir = di, -n=fileName, -t=name, -o=out.txt",
            "-d=c:\\projects, -name=fileName;, -t=name, -o=out.txt",
            "-d=c:\\projects, -n=fileName, -type=searchType, -o=out.txt",
            "-d=c:\\projects, -n=fileName, -t=name, -out=out.txt",
            "-d=c:\\projects\\job4j_design\\pom.xml, -n=fileName, -t=type, -o=out.txt",
            "-d=p:\\, -n=fileName, -t=type, -o=out.txt",
            "-d=c:\\projects, -n=fileName, -t=type, -o=out.txt"
    }, nullValues = "null")
    @DisplayName("When invalid arguments then get IllegalArgumentException")
    void searchFile(String directory, String fileName, String searchType, String target) {
        String[] args = {directory, fileName, searchType, target};
        ArgsName argsname = ArgsName.of(args);
        assertThatIllegalArgumentException().isThrownBy(() -> FileSearch.searchFile(argsname)).withMessage("Incorrect arguments");
    }

    @Test
    @DisplayName(" ")
    void whenValid() throws IOException {
        Path tempDirectory = Files.createTempDirectory("tempDirectory");
        Path tmpFile1 = Files.createTempFile(tempDirectory, "firstTestFile.txt", null);
        Path tmpFile2 = Files.createTempFile(tempDirectory, "secondTestFile", ".txt");
        Path tmpOutFile = Files.createTempFile(tempDirectory, "outFile.txt", null);
        String[] args = {"-d=tempDirectory, -n=firstTestFile, -t=name, -o=outFile.txt"};
        ArgsName argsname = ArgsName.of(args);
//        FileSearch.searchFile(argsname);
        String expected = "tempDirectory\\firstTestFile.txt";
        Scanner scanner = new Scanner(tmpOutFile).useDelimiter(System.lineSeparator());
        String result ="";
        while (scanner.hasNext()) {
            result = scanner.next();
        }
        scanner.close();
        assertThat(result).isEqualTo(expected);
    }
}