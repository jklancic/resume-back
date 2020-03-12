package xyz.blackmonster.resume.json.v1.user;

public class UserContact {

    private String uuid;

    private String phone;

    private String email;

    private String web;

    private String github;

    private String linkedin;

    public UserContact() {
    }

    public UserContact(String uuid, String phone, String email, String web, String github, String linkedin) {
        this.uuid = uuid;
        this.phone = phone;
        this.email = email;
        this.web = web;
        this.github = github;
        this.linkedin = linkedin;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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
