package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        try (var reader = new BufferedReader(new FileReader(source))) {
            List<String> list = new ArrayList<>();
            boolean start = true;
            while (reader.ready()) {
                String line = reader.readLine();
                if (start && line.contains("400") || line.contains("500")) {
                    start = false;
                    String[] split = line.split(" ");
                    list.add(split[1]);
                } else if (!start && line.contains("200") || line.contains("300")) {
                    start = true;
                    String[] split = line.split(" ");
                    list.add(" " + split[1] + ";");
                }
            }
            save(list, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(List<String> log, String file) {
        try (var out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String line: log) {
                if (line.contains(";")) {
                    out.printf("%s%n", line);
                } else {
                    out.printf("%s", line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "target.txt");
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("unavailable.csv")))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}