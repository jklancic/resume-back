package xyz.blackmonster.resume.service.model;

import java.time.LocalDate;
import java.util.List;

public class UserProfileBean {

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

    public UserProfileBean() {
    }

    public UserProfileBean(
            String uuid, String firstname, String lastname, String profession, String oneLiner, String aboutMe,
            LocalDate birth, String pdfLink, UserContactBean userContact, AddressBean address, List<JobBean> jobs,
            List<EducationBean> education, List<ExpertiseBean> expertise) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.oneLiner = oneLiner;
        this.aboutMe = aboutMe;
        this.birth = birth;
        this.pdfLink = pdfLink;
        this.userContact = userContact;
        this.address = address;
        this.jobs = jobs;
        this.education = education;
        this.expertise = expertise;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public UserContactBean getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContactBean userContact) {
        this.userContact = userContact;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<JobBean> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobBean> jobs) {
        this.jobs = jobs;
    }

    public List<EducationBean> getEducation() {
        return education;
    }

    public void setEducation(List<EducationBean> education) {
        this.education = education;
    }

    public List<ExpertiseBean> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<ExpertiseBean> expertise) {
        this.expertise = expertise;
    }
}
