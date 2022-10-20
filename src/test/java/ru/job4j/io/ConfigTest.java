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

    @Test
    @DisplayName("When pairs with comments and empty lines")
    public void whenPairWithCommentsAndEmptyLines() {
        String path = "./data/pair_with_comments_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("one", config.value("1"));
        assertEquals("username", config.value("hibernate.connection.username"));
        assertNull(config.value("3"));
    }

    @Test
    @DisplayName("When pairs with broken patterns then IllegalArgumentException")
    public void whenPairWithBrokenPatternThenIllegalArgumentException() {
        String path = "./data/pair_with_broken_pattern.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, config:: load);
        assertEquals("one", config.value("1"));
    }
}