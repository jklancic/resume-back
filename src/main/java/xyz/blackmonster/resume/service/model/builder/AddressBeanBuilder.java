package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.AddressBean;

public class AddressBeanBuilder {

    private String uuid;

    private String street;

    private String postal;

    private String city;

    private String country;

    private AddressBeanBuilder() {

    }

    public static AddressBeanBuilder instance() {
        return new AddressBeanBuilder();
    }

    public AddressBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public AddressBeanBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBeanBuilder setPostal(String postal) {
        this.postal = postal;
        return this;
    }

    public AddressBeanBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBeanBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBean build() {
        return new AddressBean(uuid, street, postal, city, country);
    }
}
