package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.AddressBean;
import xyz.blackmonster.resume.service.model.CompanyBean;
import xyz.blackmonster.resume.service.model.JobBean;

import java.util.ArrayList;
import java.util.List;

public class CompanyBeanBuilder {

    private String uuid;

    private String name;

    private String email;

    private String phone;

    private AddressBean address;

    private CompanyBeanBuilder() {

    }

    public static CompanyBeanBuilder instance() {
        return new CompanyBeanBuilder();
    }

    public CompanyBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public CompanyBeanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBeanBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyBeanBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CompanyBeanBuilder setAddress(AddressBean address) {
        this.address = address;
        return this;
    }

    public CompanyBean build() {
        return new CompanyBean(uuid, name, email, phone, address);
    }
}
