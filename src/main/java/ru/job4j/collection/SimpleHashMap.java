package ru.job4j.collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node> {

    static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(value, node.value)
                    && Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private int size = 4;
    private float capacity = 0.75f;
    private int count = 0;

    private Node<K, V>[] container = new Node[size];

    static final int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int indexTable(K key, Node<K, V>[] sizeTable) {
        return hash(key) & (sizeTable.length - 1);
    }

    private Node<K, V>[] resize() {
        size *= 4;
        Node<K, V>[] newContainer = new Node[size];
        for (Node<K, V> node : container) {
            if (node != null) {
                int index = indexTable(node.key, newContainer);
                newContainer[index] = node;
            }
        }
        container = newContainer;
        return container;
    }

    public boolean insert(K key, V value) {
        boolean rsl = true;
        int index = indexTable(key, container);
        if (container[index] == null) {
            container[index] = new Node(key, value);
            count++;
            if (count  >= container.length * capacity) {
                resize();
            }
        } else {
            rsl = false;
        }
        return rsl;
    }

    public V get(K key) {
        Node<K, V> e = container[indexTable(key, container)];
        return e.key.equals(key) ? e.value : null;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int index = indexTable(key, container);
        if (container[index] != null) {
            container[index] = null;
            count--;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int index = 0;
            int sizeIterator = count;
            Node<K, V> next = null;

            private Node findNext() {
                next = null;
                for (int i = index; i < size; i++) {
                    if (container[i] != null) {
                        index = i;
                        sizeIterator--;
                        next = container[index];
                        break;
                    }
                }
                return next;
            }

            public boolean hasNext() {
                return sizeIterator > 0;
            }


            public Node next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return findNext();
            }
        };
    }
}