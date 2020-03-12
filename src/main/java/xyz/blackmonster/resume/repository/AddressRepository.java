package xyz.blackmonster.resume.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.blackmonster.resume.repository.model.AddressDAO;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressDAO, UUID> {

    AddressDAO findByUuid(UUID uuid);
}
