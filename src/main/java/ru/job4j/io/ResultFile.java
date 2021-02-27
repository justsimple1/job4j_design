package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int one = 1;
        int two = 2;
        int onePlusTwo = one + two;
        int six = 6;
        int five = 5;
        int four = 4;
        int sixDivTwo = six / two;
        int  fiveMinusTwo = five - two;
        int fourTimeTwo = four * two;
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write((onePlusTwo + "\n" + sixDivTwo + "\n" + fiveMinusTwo + "\n" + fourTimeTwo).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
