package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.ExpertiseDAO;

import java.util.UUID;

public interface ExpertiseRepository extends CrudRepository<ExpertiseDAO, UUID> {

    ExpertiseDAO findByUuid(UUID uuid);
}
