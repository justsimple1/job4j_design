package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    ForwardLinked() {
        head = null;
        last = null;
    }
    public void add(T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, e, null);
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T temp = last.value;
        if (head.next == null) {
             head = null;
        } else {
            last.next = null;
        }
        last = last.prev;
        size--;
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }
    }
}