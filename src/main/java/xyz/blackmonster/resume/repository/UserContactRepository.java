package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.json.v1.user.UserContact;
import xyz.blackmonster.resume.repository.model.UserContactDAO;

import java.util.List;
import java.util.UUID;

public interface UserContactRepository extends CrudRepository<UserContactDAO, UUID> {

    UserContact findByUuid(UUID uuid);

    List<UserContactDAO> findAll();
}
