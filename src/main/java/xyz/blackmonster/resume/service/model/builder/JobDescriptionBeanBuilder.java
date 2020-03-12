package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.JobDescriptionBean;

public class JobDescriptionBeanBuilder {

    private String uuid;

    private String description;

    private JobDescriptionBeanBuilder() {

    }

    public static JobDescriptionBeanBuilder instance() {
        return new JobDescriptionBeanBuilder();
    }

    public JobDescriptionBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public JobDescriptionBeanBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public JobDescriptionBean build() {
        return new JobDescriptionBean(uuid, description);
    }
}
