package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int position = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.data = numbers;
    }

    @Override
    public boolean hasNext() {
        while (position < data.length && data[position] % 2 != 0) {
            position++;
        }
        return position < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[position++];
    }
}
