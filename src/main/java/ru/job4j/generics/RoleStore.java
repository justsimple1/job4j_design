package ru.job4j.generics;

    public class RoleStore <Role extends Base> implements Store<Role> {

    private final Store<Role> store = (Store<Role>) new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return delete(id);
    }

    @Override
    public Role findById(String id) {
        return findById(id);
    }
}
