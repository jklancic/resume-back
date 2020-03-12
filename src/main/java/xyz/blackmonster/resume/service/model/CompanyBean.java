package xyz.blackmonster.resume.service.model;

import java.util.Set;

public class CompanyBean {

    private String uuid;

    private String name;

    private String email;

    private String phone;

    private AddressBean address;

    public CompanyBean() {
    }

    public CompanyBean(String uuid, String name, String email, String phone, AddressBean address) {
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

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }
}
