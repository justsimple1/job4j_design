package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndex(id);
        if (index != -1) {
            mem.set(index, model);
        }
        return index != -1;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (index != -1) {
            mem.remove(index);
        }
        return index != -1;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int temp = 0; temp < mem.size(); temp++) {
            if (mem.get(temp).getId().equals(id)) {
                index = temp;
                break;
            }
        } return index;
    }

    @Override
    public T findById(String id) {
        int index = getIndex(id);
        return  index != -1 ? mem.get(index) : null;
    }

    public static void main(String[] args) {
        System.out.println(new MemStore().findById("13"));
    }
}