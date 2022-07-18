package ru.job4j.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.function.UnaryOperator;

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
    @DisplayName("Test getList")
    void testGetList() {
        List<String> expected = List.of("one", "two", "three");
        List<String> result = listOfStrings.getList();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test addElement")
    void testAddElementWhenAddFour() {
        listOfStrings.addElement("four");
        List<String> result = listOfStrings.getList();
        List<String> expected = List.of("one", "two", "three", "four");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test addElement when empty string")
    void testAddElementWhenAddFourWhenEmptyString() {
        listOfStrings.addElement("");
        List<String> result = listOfStrings.getList();
        List<String> expected = List.of("one", "two", "three", "");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test addElementToCertainPosition when position = 0")
    void testAddElementToCertainPositionWhenAddToTheTop() {
        listOfStrings.addElementToCertainPosition(0, "zero");
        assertThat(listOfStrings.getList()).startsWith("zero");
    }

    @Test
    @DisplayName("Test addElementToCertainPosition when position = 1")
    void testAddElementToCertainPositionWhenAddToThePosition1() {
        listOfStrings.addElementToCertainPosition(1, "other");
        List<String> result = listOfStrings.getList();
        List<String> expected = List.of("one", "other", "two", "three");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test addElementsFromCollection when not empty list then true")
    void testAddElementsFromCollectionWhenNotEmptyListThenTrue() {
        List<String> list = List.of("four", "five");
        assertThat(listOfStrings.addElementsFromCollection(list)).isTrue();
        assertThat(listOfStrings.getList()).containsAll(list);
    }

    @Test
    @DisplayName("Test addElementsFromCollection when empty list then false")
    void testAddElementsFromCollectionWhenEmptyListThenFalse() {
        List<String> list = List.of();
        assertThat(listOfStrings.addElementsFromCollection(list)).isFalse();
    }

    @Test
    @DisplayName("Test addElementsFromCollectionToCertainPosition when position = 1")
    void testAddElementsFromCollectionToCertainPositionWhenAddToThePosition1() {
        List<String> list = List.of("other1", "other2");
        assertThat(listOfStrings.addElementsFromCollectionToCertainPosition(1, list)).isTrue();
        List<String> expected = List.of("one", "other1", "other2", "two", "three");
        assertThat(listOfStrings.getList()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test getElement when incorrect index")
    void tesGetElementWhenInvalidIndex() {
        assertThat(listOfStrings.getElement(4)).isNull();
    }

    @Test
    @DisplayName("Test getElement when correct index")
    void tesGetElementWhenCorrectIndex() {
        assertThat(listOfStrings.getElement(1)).isEqualTo("two");
    }

    @Test
    @DisplayName("Test changeElement when correct index")
    void tesChangeElement() {
        String result = listOfStrings.changeElement(1, "other");

        String expected = "two";
        List<String> expectedList = List.of("one", "other", "three");
        assertThat(result).isEqualTo(expected);
        assertThat(listOfStrings.getList()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("Test changeElement when incorrect index then return value is null")
    void tesChangeElementWhenIncorrectIndex() {
        assertThat(listOfStrings.changeElement(5, "other")).isNull();
    }

    @Test
    @DisplayName("Test replaceAllElements")
    void tesReplaceAllElements() {
        UnaryOperator<String> operator = String::toUpperCase;
        listOfStrings.replaceAllElements(operator);

        List<String> expectedList = List.of("ONE", "TWO", "THREE");
        assertThat(listOfStrings.getList()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("Test removeElement when correct position")
    void testRemoveElementWhenCorrectPosition() {
        listOfStrings.removeElement(1);
        List<String> expectedList = List.of("one", "three");
        assertThat(listOfStrings.getList()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("Test removeElement when incorrect position then no changes")
    void testRemoveElementWhenInCorrectPosition() {
        listOfStrings.removeElement(5);
        List<String> expectedList = List.of("one", "two", "three");
        assertThat(listOfStrings.getList()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("Test removeCertainElement when correct element")
    void testRemoveCertainElementWhenCorrectElement() {
        assertThat(listOfStrings.removeCertainElement("two")).isTrue();
        assertThat(listOfStrings.getList()).doesNotContain("two");
    }

    @Test
    @DisplayName("Test removeCertainElement when incorrect element")
    void testRemoveCertainElementWhenInCorrectElement() {
        assertThat(listOfStrings.removeCertainElement("five")).isFalse();
    }

    @Test
    @DisplayName("Test removeCertainElement when two equal elements in list then remove first of them")
    void testRemoveCertainElementWhenTwoEqualElementsInList() {
        listOfStrings.addElement("two");
        assertThat(listOfStrings.removeCertainElement("two")).isTrue();
        List<String> expectedList = List.of("one", "three", "two");
        assertThat(listOfStrings.getList()).contains("two").isEqualTo(expectedList);
    }

    @Test
    @DisplayName("Test removeAllElements when remove two elements then one element is left")
    void testRemoveAllElementsWhenRemoveTwoElementsThenOneIsLeft() {
        List<String> list = List.of("one", "three");
        assertThat(listOfStrings.removeAllElements(list)).isTrue();
        assertThat(listOfStrings.getList())
                .doesNotContain("one", "three")
                .contains("two")
                .hasSize(1);
    }

    @Test
    @DisplayName("Test removeAllElements")
    void testRemoveAllElements() {
        List<String> list = List.of("one", "five");
        assertThat(listOfStrings.removeAllElements(list)).isTrue();
        assertThat(listOfStrings.getList())
                .doesNotContain("one")
                .contains("two", "three")
                .hasSize(2);
    }

    @Test
    @DisplayName("Test removeElementIf when element starts with 'o' ")
    void removeElementIfWhenElementStartsWithO() {
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
    @DisplayName("Test retainElements")
    void retainElementsWhen() {
        List<String> list = List.of("one", "five");
        assertThat(listOfStrings.retainElements(list)).isTrue();
        assertThat(listOfStrings.getList())
                .contains("one")
                .doesNotContain("two", "three")
                .hasSize(1);
    }

    @Test
    @DisplayName("Test checkIfContains when contains then true")
    void checkIfContains() {
        assertThat(listOfStrings.checkIfContains("one")).isTrue();
    }

    @Test
    @DisplayName("Test checkIfContains when does not contain then false")
    void checkIfContainsWhenDoesNotContainThenFalse() {
        assertThat(listOfStrings.checkIfContains("five")).isFalse();
    }

    @Test
    @DisplayName("Test findElement when the element is found")
    void findElement() {
        assertThat(listOfStrings.findElement("one")).isEqualTo(0);
    }

    @Test
    @DisplayName("Test findElement when element is not found then result = -1")
    void findElementWhenNotFound() {
        assertThat(listOfStrings.findElement("five")).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test returnSize when size = 3")
    void returnSize() {
        assertThat(listOfStrings.returnSize()).isEqualTo(3);
    }

    @ParameterizedTest()
    @CsvSource(value = {"-1 , 1", "3, 1", "1, 4"})
    @DisplayName("Test returnSubList")
    void testReturnSubList(int from, int to) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> listOfStrings.returnSubList(from, to));
    }

    @Test
    @DisplayName("Test returnSubList when from = 1, to = 3")
    void returnSubListWhen() {
        List<String> expectedList = List.of("two", "three");
        assertThat(listOfStrings.returnSubList(1, 3)).isEqualTo(expectedList);
    }
}