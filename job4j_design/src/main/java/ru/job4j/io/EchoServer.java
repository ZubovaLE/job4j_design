package ru.job4j.io;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.BufferedReader;
import java.io.IOException;
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

    private static final Map<String, String> serverAnswers = Map.of(
            GREETING, ANSWER_TO_GREETING,
            EXIT, ANSWER_TO_EXIT
    );

    private static String getCurrentRequest(String line) {
        int positionOfEqualSign = line.indexOf("=");
        return line.substring(positionOfEqualSign + 1, line.lastIndexOf(" "));
    }

    private static String getAnswer(String currentRequest) {
        String answer = currentRequest;
        for (String request : serverAnswers.keySet()) {
            if (currentRequest.equals(request)) {
                answer = serverAnswers.get(request);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())
                     )) {
                    String answer = "I'm a simple server.";
                    String line = in.readLine();
                    if (isNotBlank(line) && line.contains("/?msg=")) {
                        String currentRequest = getCurrentRequest(line);
                        if (currentRequest.equals(EXIT)) {
                            server.close();
                        }
                        answer = getAnswer(currentRequest);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    out.flush();
                }
            }
        }
    }
}
