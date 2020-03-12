package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="jobs")
public class JobDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<JobDescriptionDAO> duties;

	@Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = true)
    private LocalDate endTime;

    @OneToOne
    @JoinColumn(name = "companyUuid", nullable = false)
    private CompanyDAO company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userProfileUuid")
    private UserProfileDAO userProfile;

    public JobDAO() {
    }

    public JobDAO(UUID uuid, String title, Set<JobDescriptionDAO> duties, LocalDate startTime, LocalDate endTime, CompanyDAO company, UserProfileDAO userProfile) {
        this.uuid = uuid;
        this.title = title;
        this.duties = duties;
        this.startTime = startTime;
        this.endTime = endTime;
        this.company = company;
        this.userProfile = userProfile;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<JobDescriptionDAO> getDuties() {
        return duties;
    }

    public void setDuties(Set<JobDescriptionDAO> duties) {
        this.duties = duties;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public CompanyDAO getCompany() {
        return company;
    }

    public void setCompany(CompanyDAO company) {
        this.company = company;
    }

    public UserProfileDAO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
    }
}