package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.EducationDAO;

import java.util.UUID;

public interface EducationRepository extends CrudRepository<EducationDAO, UUID> {

    EducationDAO findByUuid(UUID uuid);
}
