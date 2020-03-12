package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.*;

import java.time.LocalDate;
import java.util.List;

public class UserProfileBeanBuilder {

    private String uuid;

    private String firstname;

    private String lastname;

    private String profession;

    private String oneLiner;

    private String aboutMe;

    private LocalDate birth;

    private String pdfLink;

    private UserContactBean userContact;

    private AddressBean address;

    private List<JobBean> jobs;

    private List<EducationBean> education;

    private List<ExpertiseBean> expertise;

    private UserProfileBeanBuilder() {
    }

    public static UserProfileBeanBuilder instance() {
        return new UserProfileBeanBuilder();
    }

    public UserProfileBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserProfileBeanBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserProfileBeanBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserProfileBeanBuilder setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public UserProfileBeanBuilder setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
        return this;
    }

    public UserProfileBeanBuilder setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public UserProfileBeanBuilder setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public UserProfileBeanBuilder setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
        return this;
    }

    public UserProfileBeanBuilder setUserContact(UserContactBean userContact) {
        this.userContact = userContact;
        return this;
    }

    public UserProfileBeanBuilder setAddress(AddressBean address) {
        this.address = address;
        return this;
    }

    public UserProfileBeanBuilder setJobs(List<JobBean> jobs) {
        this.jobs = jobs;
        return this;
    }

    public UserProfileBeanBuilder setEducation(List<EducationBean> education) {
        this.education = education;
        return this;
    }

    public UserProfileBeanBuilder setExpertise(List<ExpertiseBean> expertise) {
        this.expertise = expertise;
        return this;
    }

    public UserProfileBean build() {
        return new UserProfileBean(uuid, firstname, lastname, profession, oneLiner, aboutMe, birth, pdfLink, userContact, address, jobs, education, expertise);
    }
}
