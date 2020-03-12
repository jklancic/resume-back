package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.SkillDAO;

import java.util.List;
import java.util.UUID;

public interface SkillRepository extends CrudRepository<SkillDAO, UUID> {

    SkillDAO findByUuid(UUID uuid);

    List<SkillDAO> findAll();
}
