package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        Map<Integer, String> mapOfUsers = new HashMap<>();
        for (User pUser : previous) {
            mapOfUsers.put(pUser.getId(), pUser.getName());
        }
        for (User cUser : current) {
            if (!mapOfUsers.containsKey(cUser.getId())) {
                added++;
            } else if (!mapOfUsers.get(cUser.getId()).equals(cUser.getName())) {
                changed++;
            }
        }
        deleted = previous.size() + added - current.size();
        return new Info(added, changed, deleted);
    }
}
