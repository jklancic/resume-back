package xyz.blackmonster.resume.repository.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="user_profiles")
public class UserProfileDAO {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false, length = 150)
    private String oneLiner;

    @Column(nullable = false, length = 500)
    private String aboutMe;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = true, length = 500)
    private String pdfLink;

    @OneToOne
    @JoinColumn(name = "userContactUuid", nullable = false)
    private UserContactDAO userContact;

    @OneToOne
    @JoinColumn(name = "addressUuid", nullable = false)
    private AddressDAO address;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JobDAO> jobs;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EducationDAO> education;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExpertiseDAO> expertise;

    public UserProfileDAO() {
    }

    public UserProfileDAO(UUID uuid, String firstname, String lastname, String profession, String oneLiner, String aboutMe, LocalDate birth,
                          UserContactDAO userContact, AddressDAO address, Set<JobDAO> jobs, Set<EducationDAO> education, Set<ExpertiseDAO> expertise) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.oneLiner = oneLiner;
        this.aboutMe = aboutMe;
        this.birth = birth;
        this.userContact = userContact;
        this.address = address;
        this.jobs = jobs;
        this.education = education;
        this.expertise = expertise;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getOneLiner() {
        return oneLiner;
    }

    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public UserContactDAO getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContactDAO userContact) {
        this.userContact = userContact;
    }

    public AddressDAO getAddress() {
        return address;
    }

    public void setAddress(AddressDAO address) {
        this.address = address;
    }

    public Set<JobDAO> getJobs() {
        return jobs;
    }

    public void setJobs(Set<JobDAO> jobs) {
        this.jobs = jobs;
    }

    public Set<EducationDAO> getEducation() {
        return education;
    }

    public void setEducation(Set<EducationDAO> education) {
        this.education = education;
    }

    public Set<ExpertiseDAO> getExpertise() {
        return expertise;
    }

    public void setExpertise(Set<ExpertiseDAO> expertise) {
        this.expertise = expertise;
    }
}
