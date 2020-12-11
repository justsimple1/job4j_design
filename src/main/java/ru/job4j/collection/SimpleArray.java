package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    T[] array = (T[]) new Object[]{};

    /**указатель следующей пучстой ячейки в коллекции*/
    int position = 0;
    /**количество элементов в коллекции*/
    int modCount = 0;

    public T get(int index) {
        return Objects.checkIndex(index, array.length) < position ? array[index] : null;
    }

    public void add(T model) {
        modCount++;
        if (modCount >= array.length) {
            T[] newArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[position++] = model;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;
            private  int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < position && array[currentIndex] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return array[currentIndex++];
            }
        };
        return it;
    }
}