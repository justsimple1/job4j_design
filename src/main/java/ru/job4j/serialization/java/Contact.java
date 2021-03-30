package ru.job4j.serialization.java;

import java.io.*;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private int number;

    Contact(String id, int number) {
        this.number = number;
        this.id = id;
    }

    public Contact show() {
        return null;
    }

    public static void main(String[] args) {
        Contact file = new Contact("first", 123);
        System.out.println("test id = " + file.id + "test number" + file.number);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/data/file.txt"))) {
            out.writeObject(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/data/file.txt"))) {
           Contact fileFrom = (Contact) in.readObject();
            System.out.println("test id = " + fileFrom.id + "test number" + fileFrom.number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
