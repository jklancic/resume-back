package xyz.blackmonster.resume.json.v1.common;

public class Company {

    private String uuid;

    private String name;

    private String email;

    private String phone;

    private Address address;

    public Company() {
    }

    public Company(String uuid, String name, String email, String phone, Address address) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
