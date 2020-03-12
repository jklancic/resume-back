package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.JobDAO;
import xyz.blackmonster.resume.repository.model.JobDescriptionDAO;

import java.util.UUID;

public class JobDescriptionDAOBuilder {

    private UUID uuid;

    private String description;

    private JobDAO job;

    private JobDescriptionDAOBuilder() {

    }

    public static JobDescriptionDAOBuilder instance() {
        return new JobDescriptionDAOBuilder();
    }

    public JobDescriptionDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public JobDescriptionDAOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public JobDescriptionDAOBuilder setJob(JobDAO job) {
        this.job = job;
        return this;
    }

    public JobDescriptionDAO build() {
        return new JobDescriptionDAO(uuid, description, job);
    }
}
