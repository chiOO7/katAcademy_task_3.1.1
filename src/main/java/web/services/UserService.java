package web.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;

import web.model.User;
import web.repo.UserRepository;

import java.util.List;
@Transactional
@Service
public class UserService {


//    @Autowired
//    UserRepository repo;
//
//    public void save(User customer) {
//        repo.save(customer);
//    }
//
//    public List<User> listAll() {
//        return (List<User>) repo.findAll();
//    }
//
//    public User get(Long id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(Long id) {
//        repo.deleteById(id);
//    }

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
