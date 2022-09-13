package ru.job4j.io.scanner;

import java.io.*;
import java.util.Scanner;

public class ScannerUsage {
    public static void main(String[] args) {
        var ls = System.lineSeparator();
        var firstData = String.join(ls,
                "1 2 3",
                "4 5 6",
                "7 8 9"
        );
        var scanner = new Scanner(new CharArrayReader(firstData.toCharArray()));
        while (scanner.hasNextInt()) {
            System.out.print(scanner.nextInt());
            System.out.print(" ");
        }
        System.out.println();

        var secondData = "empl1@mail.ru, empl2@mail.ru, empl3@mail.ru";
        var secondScanner = new Scanner(new ByteArrayInputStream(secondData.getBytes()))
                .useDelimiter(", ");
        while (secondScanner.hasNext()) {
            System.out.println(secondScanner.next());
        }
    }
}
