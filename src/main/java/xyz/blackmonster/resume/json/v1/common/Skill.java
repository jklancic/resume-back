package xyz.blackmonster.resume.json.v1.common;

public class Skill {

    private String uuid;

    private String type;

    private int rating;

    private int scale;

    public Skill() {
    }

    public Skill(String uuid, String type, int rating, int scale) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
