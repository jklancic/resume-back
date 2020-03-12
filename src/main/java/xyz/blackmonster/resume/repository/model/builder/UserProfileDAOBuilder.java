package xyz.blackmonster.resume.repository.model.builder;

import xyz.blackmonster.resume.repository.model.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class UserProfileDAOBuilder {

    private UUID uuid;
    private String firstname;
    private String lastname;
    private String profession;
    private String oneLiner;
    private String aboutMe;
    private LocalDate birth;
    private String pdfLink;
    private UserContactDAO userContact;
    private AddressDAO address;
    private Set<JobDAO> jobs;
    private Set<EducationDAO> education;
    private Set<ExpertiseDAO> expertise;

    private UserProfileDAOBuilder() {

    }

    public static UserProfileDAOBuilder instance() {
        return new UserProfileDAOBuilder();
    }

    public UserProfileDAOBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserProfileDAOBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserProfileDAOBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserProfileDAOBuilder setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public UserProfileDAOBuilder setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
        return this;
    }

    public UserProfileDAOBuilder setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public UserProfileDAOBuilder setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public UserProfileDAOBuilder setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
        return this;
    }

    public UserProfileDAOBuilder setUserContact(UserContactDAO userContact) {
        this.userContact = userContact;
        return this;
    }

    public UserProfileDAOBuilder setAddress(AddressDAO address) {
        this.address = address;
        return this;
    }

    public UserProfileDAOBuilder setJobs(Set<JobDAO> jobs) {
        this.jobs = jobs;
        return this;
    }

    public UserProfileDAOBuilder setEducation(Set<EducationDAO> education) {
        this.education = education;
        return this;
    }

    public UserProfileDAOBuilder setExpertise(Set<ExpertiseDAO> expertise) {
        this.expertise = expertise;
        return this;
    }

    public UserProfileDAO build() {
        return new UserProfileDAO(
                uuid, firstname, lastname, profession, oneLiner, aboutMe,
                birth, userContact, address, jobs, education, expertise);
    }
}
