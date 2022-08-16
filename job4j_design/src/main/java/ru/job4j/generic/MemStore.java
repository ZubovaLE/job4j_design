package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        if (model != null) {
            storage.putIfAbsent(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (model != null) {
            result = storage.replace(id, model) != null;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
