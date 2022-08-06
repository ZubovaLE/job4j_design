package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

public class UserWithEqualsAndHashCode extends User {
    public UserWithEqualsAndHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
         return Objects.hash(getName(), getChildren(), getBirthday());
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
