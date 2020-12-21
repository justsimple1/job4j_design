package ru.job4j.collection;

import ru.job4j.generics.SimpleArray;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray arr = new SimpleArray(10);

    public boolean contains(T e) {
        boolean rsl = false;
        if (arr.size() > 0) {
            for (Object o : arr) {
                if (Objects.equals(o, e)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean add(T e) {
        return arr.size() > 0 ? !contains(e) && arr.add(e) : arr.add(e);
    }

    @Override
    public Iterator<T> iterator() {
        return arr.iterator();
    }
}
