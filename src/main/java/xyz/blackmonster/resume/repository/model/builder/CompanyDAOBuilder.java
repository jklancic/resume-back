package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.AddressDAO;
import xyz.blackmonster.resume.repository.model.CompanyDAO;
import xyz.blackmonster.resume.repository.model.JobDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CompanyDAOBuilder {

    private UUID uuid;

    private String name;

    private String email;

    private String phone;

    private AddressDAO address;

    private CompanyDAOBuilder() {

    }

    public static CompanyDAOBuilder instance() {
        return new CompanyDAOBuilder();
    }

    public CompanyDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public CompanyDAOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyDAOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyDAOBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CompanyDAOBuilder setAddress(AddressDAO address) {
        this.address = address;
        return this;
    }

    public CompanyDAO build() {
        return new CompanyDAO(uuid, name, email, phone, address);
    }
}
