package web.services;


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

    public void addUser(User customer) {
        repo.save(customer);
    }

    public List<User> showUsers() {
        return repo.findAll();
    }

    public User showUser(Long id) {
        return repo.findById(id).isPresent() ? repo.findById(id).get() : null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void update(long id, User user) {
        User toBeUpdated = repo.findById(id).isPresent() ? repo.findById(id).get() : null;
        if (toBeUpdated != null) {
            toBeUpdated.setName(user.getName());
            toBeUpdated.setLastName(user.getLastName());
            toBeUpdated.setEmail(user.getEmail());
            repo.save(toBeUpdated);
        }
    }
}
