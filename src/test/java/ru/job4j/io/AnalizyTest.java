package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("servers.log");
        File target = folder.newFile("targets.txt");
        Analizy analizy = new Analizy();
        try (PrintWriter out = new PrintWriter(new FileOutputStream("servers.log"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analizy.unavailable("servers.log", "targets.txt");
        try (var reader = new BufferedReader(new FileReader("targets.txt"))) {
            assertThat(reader.readLine(), is("10:57:01 10:59:01;"));
            assertThat(reader.readLine(), is("11:01:02 11:02:02;"));
        }
    }

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