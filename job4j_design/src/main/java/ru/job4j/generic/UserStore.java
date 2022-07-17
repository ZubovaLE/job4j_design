package ru.job4j.generic;

public class UserStore implements Store<User> {
    private final Store<User> storeOfUsers = new MemStore<>();

    @Override
    public void add(User model) {
        storeOfUsers.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return storeOfUsers.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return storeOfUsers.delete(id);
    }

    @Override
    public User findById(String id) {
        return storeOfUsers.findById(id);
    }
}
