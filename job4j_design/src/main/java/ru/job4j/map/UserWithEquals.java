package ru.job4j.map;

import java.util.*;

public class UserWithEquals extends User {
    public UserWithEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return getChildren() == user.getChildren()
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getBirthday(), user.getBirthday());
    }
}
