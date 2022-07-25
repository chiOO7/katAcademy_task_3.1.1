package web.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
