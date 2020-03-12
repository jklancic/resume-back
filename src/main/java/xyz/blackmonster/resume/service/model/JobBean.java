package xyz.blackmonster.resume.service.model;

import java.time.LocalDate;
import java.util.Set;

public class JobBean {

    private String uuid;

    private String title;

    private Set<JobDescriptionBean> duties;

    private LocalDate start;

    private LocalDate end;

    private CompanyBean company;

    private UserProfileBean userProfile;

    public JobBean() {
    }

    public JobBean(String uuid, String title, Set<JobDescriptionBean> duties, LocalDate start, LocalDate end, CompanyBean company, UserProfileBean userProfile) {
        this.uuid = uuid;
        this.title = title;
        this.duties = duties;
        this.start = start;
        this.end = end;
        this.company = company;
        this.userProfile = userProfile;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<JobDescriptionBean> getDuties() {
        return duties;
    }

    public void setDuties(Set<JobDescriptionBean> duties) {
        this.duties = duties;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public UserProfileBean getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileBean userProfile) {
        this.userProfile = userProfile;
    }
}
