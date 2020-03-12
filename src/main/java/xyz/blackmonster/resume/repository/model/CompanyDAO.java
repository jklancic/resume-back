package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="companies")
public class CompanyDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false)
    private String name;

	@Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "addressUuid", nullable = false)
    private AddressDAO address;

    public CompanyDAO() {
    }

    public CompanyDAO(UUID uuid, String name, String email, String phone, AddressDAO address) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDAO getAddress() {
        return address;
    }

    public void setAddress(AddressDAO address) {
        this.address = address;
    }
}