package ru.job4j.generic.generic;

import ru.job4j.generic.Store;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return findById(id) != null && storage.replace(id, model) != null;
    }

    @Override
    public boolean delete(String id) {
        return findById(id) != null && storage.remove(id, findById(id));
    }

    @Override
    public T findById(String id) {
        return storage.values()
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
