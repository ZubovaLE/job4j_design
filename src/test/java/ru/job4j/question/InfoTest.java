package ru.job4j.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoTest {
    private Info info;

    @BeforeEach
    void initData() {
        info = new Info(1, 1, 1);
    }

    @Test
    @DisplayName("GetAdded when added = 1")
    void getAdded() {
        assertEquals(1, info.getAdded());
    }

    @Test
    @DisplayName("SetAdded 3 then getAdded returns 3")
    void setAdded() {
        info.setAdded(3);
        assertEquals(3, info.getAdded());
    }

    @Test
    @DisplayName("GetChanged when changed = 1")
    void getChanged() {
        assertEquals(1, info.getChanged());
    }

    @Test
    @DisplayName("SetChanged 3 then getChanged returns 3")
    void setChanged() {
        info.setChanged(3);
        assertEquals(3, info.getChanged());
    }

    @Test
    @DisplayName("getDeleted when deleted = 1")
    void getDeleted() {
        assertEquals(1, info.getDeleted());
    }

    @Test
    @DisplayName("setDeleted 3 then getDeleted returns 3")
    void setDeleted() {
        info.setDeleted(3);
        assertEquals(3, info.getDeleted());
    }

    @Test
    @DisplayName("Test equals when objects are equal then true")
    void testEqualsWhenSame() {
        Info sameInfo = new Info(1, 1, 1);
        assertEquals(sameInfo, info);
    }

    @Test
    @DisplayName("Test equals when objects are not equal then false")
    void testEqualsWhenNotSame() {
        Info notSameInfo = new Info(0, 1, 1);
        assertNotEquals(notSameInfo, info);
    }

    @Test
    @DisplayName("Test hashCode when objects are equal then hashCodes are equal")
    void testHashCodeWhenEqual() {
        Info sameInfo = new Info(1, 1, 1);
        assertEquals(sameInfo.hashCode(), info.hashCode());
    }

    @Test
    @DisplayName("Test hashCode when objects are not equal then hashCodes are different")
    void testHashCodeWhenNotEqual() {
        Info notSameInfo = new Info(0, 1, 1);
        assertNotEquals(notSameInfo.hashCode(), info.hashCode());
    }
}