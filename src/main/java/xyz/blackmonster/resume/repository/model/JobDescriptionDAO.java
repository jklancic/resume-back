package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="job_descriptions")
public class JobDescriptionDAO {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobUuid")
    private JobDAO job;

    public JobDescriptionDAO() {
    }

    public JobDescriptionDAO(UUID uuid, String description, JobDAO job) {
        this.uuid = uuid;
        this.description = description;
        this.job = job;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobDAO getJob() {
        return job;
    }

    public void setJob(JobDAO job) {
        this.job = job;
    }
}
