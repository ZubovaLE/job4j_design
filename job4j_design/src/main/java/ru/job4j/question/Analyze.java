package ru.job4j.question;

import java.util.Set;

public class Analyze {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        if (!areEqual(previous, current)) {
            int oldElements = 0;
            for (User p : previous) {
                for (User c : current) {
                    if (p.equals(c)) {
                        oldElements++;
                        continue;
                    }
                    if (p.getId() == c.getId() && !p.getName().equals(c.getName())) {
                        changed++;
                    }
                }
            }
            deleted = previous.size() - oldElements - changed;
            added = current.size() - oldElements - changed;
        }
        return new Info(added, changed, deleted);
    }

    private static boolean areEqual(Set<User> previous, Set<User> current) {
        return previous.size() == current.size() && current.containsAll(previous);
    }
}
