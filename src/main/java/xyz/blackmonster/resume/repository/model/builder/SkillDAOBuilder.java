package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.JobDAO;
import xyz.blackmonster.resume.repository.model.JobDescriptionDAO;
import xyz.blackmonster.resume.repository.model.SkillDAO;

import java.util.UUID;

public class SkillDAOBuilder {

    private UUID uuid;

    private String type;

    private int rating;

    private int scale;

    private SkillDAOBuilder() {

    }

    public static SkillDAOBuilder instance() {
        return new SkillDAOBuilder();
    }

    public SkillDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public SkillDAOBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public SkillDAOBuilder setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public SkillDAOBuilder setScale(int scale) {
        this.scale = scale;
        return this;
    }

    public SkillDAO build() {
        return new SkillDAO(uuid, type, rating, scale);
    }
}
