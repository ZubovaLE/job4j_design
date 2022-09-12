package ru.job4j.encoding;

import static java.lang.Math.random;
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
        if (isNotBlank(path) && isNotBlank(botAnswers)) {
            String hello = "Hello! Write something\n";
            String firstRule = "If you want to stop my answers, write 'стоп'\n";
            String secondRule = "If you want to continue my answers, write 'продолжить'\n";
            String thirdRule = "If you want to stop this chat, write 'закончить'";
            StringBuilder greeting = new StringBuilder();
            System.out.println(greeting.append(hello).append(firstRule).append(secondRule).append(thirdRule));
            List<String> log = new ArrayList<>();
            log.add(greeting.toString());
            List<String> answers = readPhrases();
            String botAnswer = "";
            boolean botCanAnswer = true;
            try (BufferedReader readResponsesOfUser = new BufferedReader(new InputStreamReader(System.in))) {
                String responseOfUser;
                do {
                    responseOfUser = readResponsesOfUser.readLine();
                    if (responseOfUser.equals(STOP)) {
                        botCanAnswer = false;
                        log.add(responseOfUser);
                        continue;
                    } else if (responseOfUser.equals(CONTINUE)) {
                        botCanAnswer = true;
                        botAnswer = answers.get((int) (random() * (answers.size())));
                        System.out.println(botAnswer);
                    } else if (botCanAnswer && !responseOfUser.equals(OUT)) {
                        botAnswer = answers.get((int) (random() * (answers.size())));
                        System.out.println(botAnswer);
                    }
                    log.add(responseOfUser);
                    if (botCanAnswer && !responseOfUser.equals(OUT)) {
                        log.add(botAnswer);
                    }
                } while (!responseOfUser.equals(OUT));
                saveLog(log);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            answers = reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251")))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("./src/data/log.txt", "./src/data/botAnswers.txt");
        chat.run();
    }
}
