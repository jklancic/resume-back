package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.AddressDAO;
import xyz.blackmonster.resume.service.model.AddressBean;

import java.util.UUID;

public class AddressDAOBuilder {

    private UUID uuid;

    private String street;

    private String postal;

    private String city;

    private String country;

    private AddressDAOBuilder() {

    }

    public static AddressDAOBuilder instance() {
        return new AddressDAOBuilder();
    }

    public AddressDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public AddressDAOBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressDAOBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressDAOBuilder setPostal(String postal) {
        this.postal = postal;
        return this;
    }

    public AddressDAOBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressDAO build() {
        return new AddressDAO(uuid, street, postal, city, country);
    }
}
