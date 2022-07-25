package web.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Transactional
@Service
public class UserService {


    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
//
    public void addUser(User customer) {
        repo.save(customer);
    }
//
    public List<User> showUsers() {
        return (List<User>) repo.findAll();
    }
//
    public User showUser(Long id) {
        return repo.findById(id).get();
    }
//
    public void delete(Long id) {
        repo.deleteById(id);
    }

        public void update(long id, User user) {
        User toBeUpdated = repo.findById(id).get();
            toBeUpdated.setName(user.getName());
            toBeUpdated.setLastName(user.getLastName());
            toBeUpdated.setEmail(user.getEmail());
            repo.save(toBeUpdated);
    }

//    private final UserDAO userDAO;
//
//    public UserService(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//
//
//    public List<User> showUsers() {
//        return userDAO.showUsers();
//    }
//
//
//    public void addUser(User user) {
//        userDAO.addUser(user);
//    }
//
//
//    public User showUser(long id) {
//        return userDAO.showUser(id);
//    }
//
//
//    public void update(long id, User user) {
//        userDAO.update(id, user);
//    }
//
//
//    public void delete(long id) {
//        userDAO.delete(id);
//    }
}
