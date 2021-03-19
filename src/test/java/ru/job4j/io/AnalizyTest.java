package ru.job4j.io;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.io.BufferedReader;
import java.io.FileReader;

public class AnalizyTest {
    @Test
    public void whenTheRecordOfUnavailableWork() {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "target.txt");
        String line = "";
        try (var reader = new BufferedReader(new FileReader("target.txt"))) {
             assertThat(reader.readLine(), is("10:57:01 10:59:01;"));
             assertThat(reader.readLine(), is("11:01:02 11:02:02;"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}