package xyz.blackmonster.resume.json.v1.education;

import xyz.blackmonster.resume.json.v1.common.Education;

import java.util.List;

public class EducationList {

    List<Education> education;

    public EducationList() {
    }

    public EducationList(List<Education> education) {
        this.education = education;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }
}
