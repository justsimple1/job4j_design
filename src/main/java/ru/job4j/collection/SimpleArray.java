package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private T[] array = (T[]) new Object[10];

    /**указатель следующей пучстой ячейки в коллекции*/
    private int position = 0;
    /**количество элементов в коллекции*/
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, position);
        return  array[index];
    }

    public void add(T model) {
        modCount++;
        if (position >= array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[position++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;
            private  int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < position;
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