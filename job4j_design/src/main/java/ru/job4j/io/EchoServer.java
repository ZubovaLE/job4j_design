package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())
                     )) {
                    String line;
                    String answer = "I'm a simple server.";
                    line = in.readLine();
                    while (!line.isEmpty()) {
                        System.out.println(line);
                        if (line.contains("/?msg")) {
                            String[] message = line.split(" ");
                            String[] splitMsg = message[1].split("msg=", 2);
                            String request = splitMsg[1];
                            if (request.equals("Hello")) {
                                answer = "Hello, dear friend";
                            } else if (request.equals("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Server stopped".getBytes());
                                server.close();
                                break;
                            } else {
                                answer = "What";
                            }
                        }
                        line = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        }
    }
}
