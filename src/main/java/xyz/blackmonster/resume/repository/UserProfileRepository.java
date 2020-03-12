package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.UserProfileDAO;

import java.util.UUID;

public interface UserProfileRepository extends CrudRepository<UserProfileDAO, UUID> {

    UserProfileDAO findByUuid(UUID uuid);
}
