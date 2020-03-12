package xyz.blackmonster.resume.json.v1.user;

import xyz.blackmonster.resume.json.v1.common.Address;
import xyz.blackmonster.resume.json.v1.common.Education;
import xyz.blackmonster.resume.json.v1.common.Expertise;
import xyz.blackmonster.resume.json.v1.common.Job;
import xyz.blackmonster.resume.service.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class UserProfile {

    private String uuid;

    private String firstname;

    private String lastname;

    private String profession;

    private String oneLiner;

    private String aboutMe;

    private String birth;

    private UserContact userContact;

    private Address address;

    private List<Job> jobs;

    private List<Education> education;

    private List<Expertise> expertise;

    public UserProfile() {
    }

    public UserProfile(String uuid, String firstname, String lastname, String profession, String oneLiner,
                       String aboutMe, String birth, UserContact userContact, Address address, List<Job> jobs,
                       List<Education> education, List<Expertise> expertise) {
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public UserContact getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Expertise> expertise) {
        this.expertise = expertise;
    }
}
