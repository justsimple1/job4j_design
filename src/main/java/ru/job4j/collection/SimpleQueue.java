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
        boolean revert = false;
        T temp = null;
            while (in.size > -1) {
                if (in.size == 1 && !revert) {
                    temp = in.pop();
                } else {
                    if (in.size == 0) {
                        revert = true;
                    }
                    if (!revert) {
                        out.push(in.pop());
                    } else {
                        if (out.size != 0) {
                            in.push(out.pop());
                        } else {
                            break;
                        }
                    }
                }
            }
        size--;
        return temp;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
