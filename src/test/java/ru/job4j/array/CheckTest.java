package ru.job4j.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {

    @Test
    @DisplayName("Test mono when all elements are true then result is true")
    public void whenDataMonoByTrueThenTrue() {
        boolean[] data = new boolean[] {true, true, true};
        boolean result = Check.mono(data);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test mono when  elements are true,false,true then result is false")
    public void whenDataNotMonoByTrueThenFalse() {
        boolean[] data = new boolean[] {true, false, true};
        boolean result = Check.mono(data);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test mono when all elements are false then result is true")
    public void whenDataMonoByFalseThenTrue() {
        boolean[] data = new boolean[] {false, false, false};
        boolean result = Check.mono(data);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test when data is not mono, then result is false")
    public void whenDataNotMonoByFalseThenFalse() {
        boolean[] data = new boolean[] {false, true, false};
        boolean result = Check.mono(data);
        assertFalse(result);
    }
}