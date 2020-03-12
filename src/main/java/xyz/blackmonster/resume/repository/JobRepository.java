package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.JobDAO;

import java.util.UUID;

public interface JobRepository extends CrudRepository<JobDAO, UUID> {

    JobDAO findByUuid(UUID uuid);
}
