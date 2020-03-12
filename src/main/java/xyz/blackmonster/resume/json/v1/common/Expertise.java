package xyz.blackmonster.resume.json.v1.common;

import java.util.List;

public class Expertise {

    private String uuid;

    private String category;

    private List<Skill> proficient;

    private boolean favorite;

    public Expertise() {
    }

    public Expertise(String uuid, String category, List<Skill> proficient, boolean favorite) {
        this.uuid = uuid;
        this.category = category;
        this.proficient = proficient;
        this.favorite = favorite;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Skill> getProficient() {
        return proficient;
    }

    public void setProficient(List<Skill> proficient) {
        this.proficient = proficient;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
