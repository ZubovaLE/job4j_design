package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyze {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        Map<Integer, String> mapOfUsers;
        mapOfUsers = previous.stream()
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName
                ));
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
