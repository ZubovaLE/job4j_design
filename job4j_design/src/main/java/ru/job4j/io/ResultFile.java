package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(ResultFile.multiplicationTable().getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String multiplicationTable() {
        String ln = System.lineSeparator();
        StringBuilder data = new StringBuilder();
        int result;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                result = i * j;
                data.append(result).append(result < 10 ? "  " : " ");
            }
            data.deleteCharAt(data.length() - 1).append(ln);
        }
        return data.toString().trim();
    }
}
