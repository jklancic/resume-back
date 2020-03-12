package xyz.blackmonster.resume.json.v1.user;

import xyz.blackmonster.resume.json.v1.common.Education;
import xyz.blackmonster.resume.json.v1.common.Expertise;
import xyz.blackmonster.resume.json.v1.common.Job;

import java.util.List;

public class Resume {

    private UserProfile user;

    private List<Education> education;

    private List<Job> career;

    private List<Expertise> expertise;

    public Resume() {
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Job> getCareer() {
        return career;
    }

    public void setCareer(List<Job> career) {
        this.career = career;
    }

    public List<Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Expertise> expertise) {
        this.expertise = expertise;
    }
}
