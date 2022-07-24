package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static long USER_COUNT;
    private final List<User> users;

    {
        users = new ArrayList<>();
        for(int i = 1; i < 5; i++) {
            users.add(new User(++USER_COUNT, "name" + i, "last name" + i, "user" + i + "@mail.ru"));
        }
    }

    public List<User> showUsers() {
        return users;
    }

    public void addUser(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public User showUser(long id) {
       return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void update(long id, User user) {
        User toBeUpdated = showUser(id);
        toBeUpdated.setName(user.getName());
        toBeUpdated.setLastName(user.getLastName());
        toBeUpdated.setEmail(user.getEmail());
    }

    public void delete(long id) {
        users.removeIf(u -> u.getId() == id);
    }
}
