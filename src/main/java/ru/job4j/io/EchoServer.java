package ru.job4j.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String temp = "";
                    while (!str.isEmpty()) {
                        System.out.println(str + "yes!!");
                        if (str.contains("Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                            break;
                        } else if (str.contains("Exit")) {
                            server.close();
                        } else {
                            out.write("What ?".getBytes());
                            break;
                        }
                        temp = in.readLine();
                        if (!temp.isEmpty()) {
                            str = temp;
                        }
                            break;
                        }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }
            }
        }
    }
}