package ru.job4j.encoding;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String OUT = "закончить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        if (isNotBlank(path)) {
            File file = new File(path);
            List<String> phrases = new ArrayList<>();
            StringBuilder log = new StringBuilder();
            String ln = System.lineSeparator();
            boolean botCanAnswer = true;
            try (BufferedReader readResponsesOfUser = new BufferedReader(new InputStreamReader(System.in))) {
                log.append("Hello! Write something").append(ln)
                        .append("If you want to stop my answers, write 'стоп'").append(ln)
                        .append("If you want to continue my answers, write 'продолжить'").append(ln)
                        .append("If you want to stop this chat, write 'стоп'").append(ln);
                String responseOfUser = "";
                while (!responseOfUser.equals(OUT)) {
                    responseOfUser = readResponsesOfUser.readLine();
                    log.append(responseOfUser);
                    if (responseOfUser.equals(STOP)) {
                        botCanAnswer = false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> readPhrases() {
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            return reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("", "botAnswers");
        chat.run();
    }
}
