package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.CompanyDAO;

import java.util.UUID;

public interface CompanyRepository extends CrudRepository<CompanyDAO, UUID> {

    CompanyDAO findByUuid(UUID uuid);
}
