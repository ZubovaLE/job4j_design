package ru.job4j.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AnalizyTest {
    @ParameterizedTest
    @CsvSource(value = {"200 10:56:01, 500 10:57:01, 400 10:58:01, 200 10:59:01, 500 11:01:02, 200 11:02:02",
            "500 10:57:01,  , 200 10:59:01, 500, 500 11:01:02, 200 11:02:02"})
    @DisplayName("Test unavailable with correct lines and with broken lines")
    void testUnavailable(String firstData, String secondData, String thirdData,
                         String fourthData, String fifthData, String sixthData) throws IOException {

        File source = File.createTempFile("source.txt", null);
        File target = File.createTempFile("target.txt", null);
        try (PrintWriter out = new PrintWriter(source)) {
            out.println(firstData);
            out.println(secondData);
            out.println(thirdData);
            out.println(fourthData);
            out.println(fifthData);
            out.println(sixthData);
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(l -> rsl.append(l).append("\n"));
        }
        assertThat(rsl.toString(), is("""
                10:57:01;10:59:01
                11:01:02;11:02:02
                """));
    }
}