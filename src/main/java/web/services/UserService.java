package web.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;

import web.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }



    public List<User> showUsers() {
        return userDAO.showUsers();
    }


    public void addUser(User user) {
        userDAO.addUser(user);
    }


    public User showUser(long id) {
        return userDAO.showUser(id);
    }


    public void update(long id, User user) {
        userDAO.update(id, user);
    }


    public void delete(long id) {
        userDAO.delete(id);
    }
}
