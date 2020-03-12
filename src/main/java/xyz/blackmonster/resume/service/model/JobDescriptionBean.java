package xyz.blackmonster.resume.service.model;

public class JobDescriptionBean {

    private String uuid;

    private String description;

    public JobDescriptionBean() {
    }

    public JobDescriptionBean(String uuid, String description) {
        this.uuid = uuid;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
