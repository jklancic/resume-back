package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.JobDescriptionDAO;

import java.util.List;
import java.util.UUID;

public interface JobDescriptionRepository extends CrudRepository<JobDescriptionDAO, UUID> {

    JobDescriptionDAO findByUuid(UUID uuid);

    List<JobDescriptionDAO> findAll();
}
