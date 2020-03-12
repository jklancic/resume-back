package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.UserDAO;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserDAO, UUID> {

    UserDAO findByUuid(UUID uuid);

    UserDAO findByUsername(String username);

    UserDAO findByUsernameAndPassword(String username, String password);

    List<UserDAO> findAll();
}
