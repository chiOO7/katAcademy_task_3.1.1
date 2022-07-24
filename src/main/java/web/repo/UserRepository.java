package web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
