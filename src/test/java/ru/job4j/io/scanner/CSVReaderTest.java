package ru.job4j.io.scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CSVReaderTest {
    @Test
    @DisplayName("Test handle when filter two columns")
    public void whenFilterTwoColumns() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = File.createTempFile("source.csv", null);
        File target = File.createTempFile("target.csv", null);
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        });
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;age",
                "Tom;20",
                "Jack;25",
                "William;30"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        assertThat(Files.readString(target.toPath()), is(expected));
    }
}