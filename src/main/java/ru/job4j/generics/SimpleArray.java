package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int capacity;
    private int position = 0;
    private T[] array;

    /**
     * Конструктор класса
     * @param size -  количество ячеек.
     * */
    public SimpleArray(int size) {
        this.capacity = size;
        this.array = (T[]) new Object[capacity];
    }
    public int size() {
        return position;
    }
    /**
     * Метод  добавляет указанный элемент (model) в первую свободную ячейку;
     * @param model - добавляемый элемент
     * @return - добавлен ли элемент;
     * */
    public boolean add(T model) {
        boolean rsl = false;
        if (position <= capacity) {
            this.array[position] = model;
            position++;
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод заменяет указанный элементом (model) элемент, находящийся по индексу index;
     * @param model - элемент на который заменяем текущий элемент
     * @param index - индекс текущего элемента, который заменяем.
     * @return rsl - успешно ли прошла замена.
     * */
    public  boolean set(int index, T model) {
        boolean rsl = false;
        if (Objects.checkIndex(index, capacity) < position) {
            this.array[index] = model;
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод удаляет элемент по указанному индексу
     * @param index - индекс элемента, который удаляем.
     * @return rsl - удалён ли элемент.
     * */
    public boolean remove(int index) {
        boolean rsl = false;
        if (Objects.checkIndex(index, capacity) < position) {
            System.arraycopy(array, index + 1, array, index, capacity - index - 1);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу.
     * @param index - индекс элемента, который нужно вернуть.
     * @return rsl - элемент, найденный по указанному индексу.
     * */
    public T get(int index) {
        T rsl = null;
        if (Objects.checkIndex(index, capacity) < position) {
            rsl = array[index];
        }
        return rsl;
    }

    /**
     * Реалиуем метод iterator() интерфейса Iterable.
     * @return it - итератор, класса SimpleArray.
     * */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
        return it;
    }
}
