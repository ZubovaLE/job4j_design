package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Map.entry;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class EchoServer {
    private static final String GREETING = "Hello";
    private static final String ANSWER_TO_GREETING = "Hello, dear friend";
    private static final String EXIT = "Bye";
    private static final String ANSWER_TO_EXIT = "Server was stopped";
    public static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class.getName());

    private static final Map<String, String> serverAnswers = Map.ofEntries(
            entry(GREETING, ANSWER_TO_GREETING),
            entry(EXIT, ANSWER_TO_EXIT)
    );

    private static String getCurrentRequest(String line) {
        int positionOfEqualSign = line.indexOf("=");
        return line.substring(positionOfEqualSign + 1, line.lastIndexOf(" "));
    }

    private static String getAnswer(String currentRequest) {
        String answer = serverAnswers.get(currentRequest);
        return answer != null ? answer : currentRequest;
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())
                     )) {
                    String answer;
                    String line = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (isNotBlank(line) && line.contains("/?msg=")) {
                        String currentRequest = getCurrentRequest(line);
                        if (currentRequest.equals(EXIT)) {
                            server.close();
                        }
                        answer = getAnswer(currentRequest);
                        out.write(answer.getBytes());
                        out.flush();
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("There are problems with socket");
        }
    }
}
