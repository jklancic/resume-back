package xyz.blackmonster.resume.service.model;

import java.util.List;

public class ExpertiseBean {

    private String uuid;

    private String category;

    private List<SkillBean> proficient;

    private Boolean favorite;

    private UserProfileBean userProfile;

    public ExpertiseBean() {
    }

    public ExpertiseBean(String uuid, String category, List<SkillBean> proficient, Boolean favorite, UserProfileBean userProfile) {
        this.uuid = uuid;
        this.category = category;
        this.proficient = proficient;
        this.favorite = favorite;
        this.userProfile = userProfile;
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

    public List<SkillBean> getProficient() {
        return proficient;
    }

    public void setProficient(List<SkillBean> proficient) {
        this.proficient = proficient;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public UserProfileBean getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileBean userProfile) {
        this.userProfile = userProfile;
    }
}
