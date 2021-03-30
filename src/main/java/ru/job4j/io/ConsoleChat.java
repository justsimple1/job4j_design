package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    private List asks = new ArrayList();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Давай поговорим, задавай вопрос");
        boolean work = true;
        boolean speak = true;
        answersToList();
        Random r = new Random();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            while (work) {
                String select = input.nextLine();
                out.write(select + System.lineSeparator());
                if (select.equals(STOP)) {
                    speak = false;
                } else if (select.equals(CONTINUE)) {
                    speak = true;
                } else if (select.equals(OUT)) {
                    work = false;
                }
                if (speak) {
                    String answer = asks.get(r.nextInt(asks.size())).toString();
                    out.write(answer + System.lineSeparator());
                    System.out.println(answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void answersToList() {
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers))) {
            while (read.ready()) {
                asks.add(read.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/dialog.txt", "./src/data/botAnswers.txt");
        cc.run();
    }
}
