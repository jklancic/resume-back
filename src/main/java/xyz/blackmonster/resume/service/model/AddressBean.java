package xyz.blackmonster.resume.service.model;

public class AddressBean {

    private String uuid;

    private String street;

    private String postal;

    private String city;

    private String country;

    public AddressBean() {
    }

    public AddressBean(String uuid, String street, String postal, String city, String country) {
        this.uuid = uuid;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.country = country;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
