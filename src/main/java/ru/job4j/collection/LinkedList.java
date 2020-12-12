package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements Iterable<T> {
    /**Ссылка на первый элемент*/
    transient Node<T> first;
    /**Ссылка на последний элемент**/
    transient Node<T> last;
    /**указатель следующей пучстой ячейки в коллекции*/
    transient int size = 0;
    /**количество элементов в коллекции*/
    private int modCount = 0;

    LinkedList() {
        first = null;
        last = null;
    }

    private static class Node<E> {
       private E item;
       private Node<E> next;
        Node(E element) {
            this.item = element;
        }
    }

    public void add(T value) {
        final Node<T> newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current;
    }
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private  int expectedModCount = modCount;
            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) current.next;
            }
        };
        return it;
    }
}
