package xyz.blackmonster.resume.service.model;

public class SkillBean {

    private String uuid;

    private String type;

    private Integer rating;

    private Integer scale;

    public SkillBean() {
    }

    public SkillBean(String uuid, String type, int rating, int scale) {
        this.uuid = uuid;
        this.type = type;
        this.rating = rating;
        this.scale = scale;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }
}
