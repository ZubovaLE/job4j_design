package ru.job4j.question;

import java.util.Set;

public class Analyze {
    public static Info diff(Set<User> previous, Set<User> current) {
        int changed = 0;
        Info rsl = new Info(0, 0, 0);
        int result = previous.size() - current.size();
        if (result > 0) {
            rsl.setDeleted(result);
        } else if (result < 0) {
            rsl.setAdded(Math.abs(result));
        }
        for (User p : previous) {
            for (User c : current) {
                if (p.getId() == c.getId() && !p.getName().equals(c.getName())) {
                    changed++;
                }
            }
        }
        rsl.setChanged(changed);
        return rsl;
    }
}
