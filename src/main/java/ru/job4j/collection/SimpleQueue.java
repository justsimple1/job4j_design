package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        if (in.size == out.size) {
            throw new NoSuchElementException();
        }
        T temp = null;
        if (in.size > out.size) {
            while (in.size != 1) {
                out.push(in.pop());
            }
           temp = in.pop();
        } else {
            while (out.size != 1) {
                in.push(out.pop());
            }
            temp = out.pop();
        }
        size--;
        return temp;
    }

    public void push(T value) {
        if (out.size > in.size) {
            out.push(value);
        } else {
            in.push(value);
        }
        size++;
    }
}
