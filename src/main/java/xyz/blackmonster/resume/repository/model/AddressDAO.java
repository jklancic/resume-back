package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="addresses")
public class AddressDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postal;

	@Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    public AddressDAO() {
    }

    public AddressDAO(UUID uuid, String street, String postal, String city, String country) {
        this.uuid = uuid;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.country = country;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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