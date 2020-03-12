package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="user_contacts")
public class UserContactDAO {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String web;

    @Column(nullable = true)
    private String github;

    @Column(nullable = false)
    private String linkedin;

    public UserContactDAO() {
    }

    public UserContactDAO(UUID uuid, String phone, String email, String web, String github, String linkedin) {
        this.uuid = uuid;
        this.phone = phone;
        this.email = email;
        this.web = web;
        this.github = github;
        this.linkedin = linkedin;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
