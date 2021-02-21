package week05d03.senior;

import java.util.List;

public class UserValidator {

    public void validate(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("list is null");
        }
        for (User user: users) {
            if (user == null) {
                throw new IllegalArgumentException("user is null");
            }
            if (user.getName() == null || user.getName().isBlank()) {
                throw new IllegalArgumentException("invalid user name" + user.getName());
            }
            if (user.getAge() < 0 || user.getAge() > 120) {
                throw new IllegalArgumentException("invalid user age" + user.getAge());
            }

        }
    }
}
