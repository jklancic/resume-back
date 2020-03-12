package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.ExpertiseDAO;
import xyz.blackmonster.resume.repository.model.SkillDAO;
import xyz.blackmonster.resume.repository.model.UserProfileDAO;

import java.util.Set;
import java.util.UUID;

public class ExpertiseDAOBuilder {

    private UUID uuid;

    private String category;

    private Set<SkillDAO> proficient;

    private boolean favorite;

    private UserProfileDAO userProfile;

    private ExpertiseDAOBuilder() {

    }

    public static ExpertiseDAOBuilder instance() {
        return new ExpertiseDAOBuilder();
    }

    public ExpertiseDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public ExpertiseDAOBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ExpertiseDAOBuilder setProficient(Set<SkillDAO> proficient) {
        this.proficient = proficient;
        return this;
    }

    public ExpertiseDAOBuilder setFavorite(boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public ExpertiseDAOBuilder setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    public ExpertiseDAO build() {
        return new ExpertiseDAO(uuid, category, proficient, favorite, userProfile);
    }
}
