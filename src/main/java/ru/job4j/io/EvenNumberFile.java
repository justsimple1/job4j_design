package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder number = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                number.append((char) read);
            }
            String[] lines = number.toString().split(System.lineSeparator());
            for (String line : lines) {
                boolean result = Integer.parseInt(line) % 2 == 0;
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}