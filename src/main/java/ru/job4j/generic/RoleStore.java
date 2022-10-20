package ru.job4j.generic;

public class RoleStore implements Store<Role> {
    private final Store<Role> storeOfRoles = new MemStore<>();

    @Override
    public void add(Role model) {
        storeOfRoles.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return storeOfRoles.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return storeOfRoles.delete(id);
    }

    @Override
    public Role findById(String id) {
        return storeOfRoles.findById(id);
    }
}
