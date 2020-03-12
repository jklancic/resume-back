package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="education")
public class EducationDAO {
	
	@Id
    @GeneratedValue
    private UUID uuid;

	@Column(nullable = false)
    private String title;

	@Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String institution;

	@Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = true)
    private LocalDate endTime;

    @Column(nullable = false)
    private boolean certification;

    @OneToOne
    @JoinColumn(name = "addressUuid", nullable = false)
    private AddressDAO address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userProfileUuid")
    private UserProfileDAO userProfile;

    public EducationDAO() {
    }

    public EducationDAO(UUID uuid, String title, String description, String institution, LocalDate startTime, LocalDate endTime, boolean certification, AddressDAO address, UserProfileDAO userProfile) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.institution = institution;
        this.startTime = startTime;
        this.endTime = endTime;
        this.certification = certification;
        this.address = address;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public AddressDAO getAddress() {
        return address;
    }

    public void setAddress(AddressDAO address) {
        this.address = address;
    }

    public UserProfileDAO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDAO userProfile) {
        this.userProfile = userProfile;
    }
}