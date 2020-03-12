package xyz.blackmonster.resume.json.v1.common;

public class JobDescription {

    private String uuid;

    private String description;

    public JobDescription() {
    }

    public JobDescription(String uuid, String description) {
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
