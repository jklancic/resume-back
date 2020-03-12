package xyz.blackmonster.resume.service.model;

import java.time.LocalDate;

public class EducationBean {

    private String uuid;

    private String title;

    private String description;

    private String institution;

    private LocalDate start;

    private LocalDate end;

    private AddressBean address;

    private boolean certification;

    private UserProfileBean userProfile;

    public EducationBean() {
    }

    public EducationBean(String uuid, String title, String description, String institution, LocalDate start, LocalDate end, AddressBean address, boolean certification, UserProfileBean userProfile) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.institution = institution;
        this.start = start;
        this.end = end;
        this.address = address;
        this.certification = certification;
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

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public UserProfileBean getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileBean userProfile) {
        this.userProfile = userProfile;
    }
}
