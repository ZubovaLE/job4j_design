package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

public class UserWithHashCode extends User {
    public UserWithHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBirthday());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
