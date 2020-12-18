package ru.job4j.collection;

import ru.job4j.generics.SimpleArray;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray arr = new SimpleArray(10);
    private int modCount = 0;

    public boolean add(T e) {
        modCount++;
        boolean rsl = true;
        if (arr.size() > 0) {
            while (iterator().hasNext()) {
                iterator().next();
                if (iterator() == e) {
                    rsl = false;
                    break;
                }
            }
            if (rsl) {
                arr.add(e);
            }
        } else if (arr.size() == 0) {
            arr.add(e);
        }
       return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            Iterator<T> iterator = arr.iterator();
            private  int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterator.next();
            }
        };
        return it;
    }
}
