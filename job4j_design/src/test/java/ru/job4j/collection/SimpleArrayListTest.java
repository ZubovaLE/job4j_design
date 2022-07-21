package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.list.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    List<Integer> list;

    @BeforeEach
    public void initData() {
        list = new SimpleArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThenSizeIncrease() {
        assertEquals(3, list.size());
    }

    @Test
    public void whenRemoveThenGetValueAndSizeDecrease() {
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(2), list.remove(1));
        assertEquals(2, list.size());
    }
}