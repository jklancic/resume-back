package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class UserContactDAOBuilder {

    private UUID uuid;
    private String phone;
    private String email;
    private String web;
    private String github;
    private String linkedin;

    private UserContactDAOBuilder() {

    }

    public static UserContactDAOBuilder instance() {
        return new UserContactDAOBuilder();
    }

    public UserContactDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserContactDAOBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserContactDAOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserContactDAOBuilder setWeb(String web) {
        this.web = web;
        return this;
    }

    public UserContactDAOBuilder setGithub(String github) {
        this.github = github;
        return this;
    }

    public UserContactDAOBuilder setLinkedin(String linkedin) {
        this.linkedin = linkedin;
        return this;
    }

    public UserContactDAO build() {
        return new UserContactDAO(uuid, phone, email, web, github, linkedin);
    }
}
