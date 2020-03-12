package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.CompanyDAO;
import xyz.blackmonster.resume.repository.model.JobDAO;
import xyz.blackmonster.resume.repository.model.JobDescriptionDAO;
import xyz.blackmonster.resume.repository.model.UserProfileDAO;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class JobDAOBuilder {

    private UUID uuid;

    private String title;

    private Set<JobDescriptionDAO> duties;

    private LocalDate start;

    private LocalDate end;

    private CompanyDAO company;

    private UserProfileDAO userProfile;

    private JobDAOBuilder() {

    }

    public static JobDAOBuilder instance() {
        return new JobDAOBuilder();
    }

    public JobDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public JobDAOBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public JobDAOBuilder setDuties(Set<JobDescriptionDAO> duties) {
        this.duties = duties;
        return this;
    }

    public JobDAOBuilder setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public JobDAOBuilder setEnd(LocalDate end) {
        this.end = end;
        return this;
    }

    public JobDAOBuilder setCompany(CompanyDAO company) {
        this.company = company;
        return this;
    }

    public JobDAOBuilder setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    public JobDAO build() {
        return new JobDAO(uuid, title, duties, start, end, company, userProfile);
    }
}
