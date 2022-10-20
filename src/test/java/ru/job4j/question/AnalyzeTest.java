package ru.job4j.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AnalyzeTest {
    private User u1;
    private User u2;
    private User u3;

    @BeforeEach
    void initData() {
        u1 = new User(1, "A");
        u2 = new User(2, "B");
        u3 = new User(3, "C");
    }

    @Test
    @DisplayName("Test diff when set is not changed")
    void whenNotChanged() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 0, 0))
        );
    }

    @Test
    @DisplayName("Test diff when one element is changed")
    void whenOneIsChanged() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 1, 0))
        );
    }

    @Test
    @DisplayName("Test diff when one element is deleted")
    void whenOneIsDeleted() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 0, 1))
        );
    }

    @Test
    @DisplayName("Test diff when one element is added")
    void whenOneIsAdded() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(1, 0, 0))
        );
    }

    @Test
    @DisplayName("Test diff when all elements are changed")
    public void whenAllElementsAreChanged() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(1, "AA"), new User(2, "BB"), new User(3, "CC"));
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 3, 0))
        );
    }

    @Test
    @DisplayName("Test diff when all elements are deleted")
    public void whenAllElementsAreDeleted() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of();
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 0, 3))
        );
    }

    @Test
    @DisplayName("Test diff when new elements are added")
    public void whenNewElementsAreAdded() {
        User u4 = new User(4, "D");
        User u5 = new User(5, "E");
        User u6 = new User(6, "F");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, u4, u5, u6);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(3, 0, 0))
        );
    }

    @Test
    @DisplayName("Test diff when one el is changed, other el is deleted and new one is added")
    public void whenOneIsChangedOneIsDeletedAndNewIsAdded() {
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(1, "AA"), u2, new User(4, "D"));
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(1, 1, 1))
        );
    }

    @Test
    @DisplayName("Test diff when one el is changed and new one is added")
    public void whenChange1ElAdd1El() {
        Set<User> previous = Set.of(u1, u2);
        Set<User> current = Set.of(new User(1, "AA"), u2, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(1, 1, 0))
        );
    }

    @Test
    @DisplayName("Test diff when one el is deleted and new one is added")
    public void whenDelete1ElAdd1El() {
        Set<User> previous = Set.of(u1, u2);
        Set<User> current = Set.of(u2, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(1, 0, 1))
        );
    }

    @Test
    @DisplayName("Test diff when one el is deleted and one is changed")
    public void whenDelete1ElChange1El() {
        Set<User> previous = Set.of(u1, u2);
        Set<User> current = Set.of(new User(2, "BB"));
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 1, 1))
        );
    }
}