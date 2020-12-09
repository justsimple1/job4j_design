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
        boolean rsl = false;
        T current = findById(id);
        if (current != null){
            mem.set(getIndex(current), model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        T current = findById(id);
        if (current != null){
            mem.remove(getIndex(current));
            rsl = true;
        }
        return rsl;
    }

    private int getIndex(T current) {
        int index = 0;
        for (T model : mem) {
            index++;
            if (model.equals(current)) break;
        } return index;
    }

    @Override
    public T findById(String id) {
        T find = null;
        for (T model : mem) {
            if (model.getId() == id) {
                find = model;
                break;
            }
        }
        return find;
    }
}