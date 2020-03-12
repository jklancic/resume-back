package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.UserContactBean;

import java.util.UUID;

public class UserContactBeanBuilder {

    private String uuid;

    private String phone;

    private String email;

    private String web;

    private String github;

    private String linkedin;

    private UserContactBeanBuilder() {
    }

    public static UserContactBeanBuilder instance() {
        return new UserContactBeanBuilder();
    }

    public UserContactBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserContactBeanBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserContactBeanBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserContactBeanBuilder setWeb(String web) {
        this.web = web;
        return this;
    }

    public UserContactBeanBuilder setGithub(String github) {
        this.github = github;
        return this;
    }

    public UserContactBeanBuilder setLinkedin(String linkedin) {
        this.linkedin = linkedin;
        return this;
    }

    public UserContactBean build() {
        return new UserContactBean(uuid, phone, email, web, github, linkedin);
    }
}
