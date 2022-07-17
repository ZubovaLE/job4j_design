package ru.job4j.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListUsageTest {
    private ListUsage<String> listOfStrings;

    @BeforeEach
    public void setUp() {
        listOfStrings = new ListUsage<>();
        listOfStrings.addElement("one");
        listOfStrings.addElement("two");
        listOfStrings.addElement("three");
    }

    @Test
    @DisplayName("Test removeElements when remove two elements then one element is left")
    void removeElements() {
        List<String> list = List.of("one", "three");
        assertThat(listOfStrings.removeAllElements(list)).isTrue();
        assertThat(listOfStrings.getList())
                .doesNotContain("one", "three")
                .contains("two")
                .hasSize(1);
    }

    @Test
    @DisplayName("Test removeElementIf when remove element starts with 'o' ")
    void removeElementIf() {
        assertThat(listOfStrings.removeElementIf(s -> s.startsWith("o"))).isTrue();
        assertThat(listOfStrings.getList())
                .doesNotContain("one")
                .contains("two", "three")
                .hasSize(2);
    }

    @Test
    @DisplayName("Test retainElements when retain two elements then one element is deleted")
    void retainElements() {
        List<String> list = List.of("one", "three");
        assertThat(listOfStrings.retainElements(list)).isTrue();
        assertThat(listOfStrings.getList())
                .contains("one", "three")
                .doesNotContain("two")
                .hasSize(2);
    }

    @Test
    @DisplayName("Test checkIfContains")
    void checkIfContains() {
        assertThat(listOfStrings.checkIfContains("one")).isTrue();
    }

    @Test
    @DisplayName("Test findElement")
    void findElement() {
        assertThat(listOfStrings.findElement("one")).isEqualTo(0);
    }

    @Test
    @DisplayName("Test returnSize when size = 3")
    void returnSize() {
        assertThat(listOfStrings.returnSize()).isEqualTo(3);
    }
}