package ru.job4j.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {
    @Test
    @DisplayName("When pairs without comments")
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("aa", config.value("1"));
        assertEquals("username", config.value("hibernate.connection.username"));
        assertNull(config.value("user"));
    }
}