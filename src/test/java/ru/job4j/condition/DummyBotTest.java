package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyBotTest {

    @Test
    @DisplayName("Test the method 'answer' when greet the Bot")
    void whenGreetBot() {
        String in = "Привет, Бот.";
        String out = DummyBot.answer(in);
        String expected = "Привет, умник.";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'answer' when bye the Bot")
    void whenByeBot() {
        String in = "Пока.";
        String out = DummyBot.answer(in);
        String expected = "До скорой встречи.";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test the method 'answer' when ask smt wrong")
    void whenUnknownBot() {
        String in = "Сколько будет 2 + 2?";
        String out = DummyBot.answer(in);
        String expected = "Это ставит меня в тупик. Задайте другой вопрос.";
        assertEquals(expected, out);
    }
}