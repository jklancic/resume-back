package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.SkillBean;

public class SkillBeanBuilder {

    private String uuid;

    private String type;

    private int rating;

    private int scale;

    private SkillBeanBuilder() {
    }

    public static SkillBeanBuilder instance() {
        return new SkillBeanBuilder();
    }

    public SkillBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public SkillBeanBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public SkillBeanBuilder setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public SkillBeanBuilder setScale(int scale) {
        this.scale = scale;
        return this;
    }

    public SkillBean build() {
        return new SkillBean(uuid, type, rating, scale);
    }
}
