package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.ExpertiseBean;
import xyz.blackmonster.resume.service.model.SkillBean;

import java.util.List;

public class ExpertiseBeanBuilder {

    private String uuid;

    private String category;

    private List<SkillBean> proficient;

    private boolean favorite;

    private ExpertiseBeanBuilder() {

    }

    public static ExpertiseBeanBuilder instance() {
        return new ExpertiseBeanBuilder();
    }

    public ExpertiseBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public ExpertiseBeanBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ExpertiseBeanBuilder setProficient(List<SkillBean> proficient) {
        this.proficient = proficient;
        return this;
    }

    public ExpertiseBeanBuilder setFavorite(boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public ExpertiseBean build() {
        return new ExpertiseBean(uuid, category, proficient, favorite, null);
    }
}
