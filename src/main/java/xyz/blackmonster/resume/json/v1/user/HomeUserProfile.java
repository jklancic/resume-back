package xyz.blackmonster.resume.json.v1.user;

import xyz.blackmonster.resume.json.v1.common.Expertise;

public class HomeUserProfile {

    private String firstname;

    private String lastname;

    private String profession;

    private String oneLiner;

    private String aboutMe;

    private String birth;

    private String pdfLink;

    private UserContact userContact;

    private Expertise favoriteExpertise;

    public HomeUserProfile() {
    }

    public HomeUserProfile(String firstname, String lastname, String profession, String oneLiner,
                           String aboutMe, String birth, UserContact userContact, Expertise favoriteExpertise) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.oneLiner = oneLiner;
        this.aboutMe = aboutMe;
        this.birth = birth;
        this.userContact = userContact;
        this.favoriteExpertise = favoriteExpertise;
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

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public UserContact getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    public Expertise getFavoriteExpertise() {
        return favoriteExpertise;
    }

    public void setFavoriteExpertise(Expertise favoriteExpertise) {
        this.favoriteExpertise = favoriteExpertise;
    }
}
