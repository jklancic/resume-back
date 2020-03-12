package xyz.blackmonster.resume.json.v1.expertise;

import xyz.blackmonster.resume.json.v1.common.Expertise;

import java.util.List;

public class ExpertiseList {

    List<Expertise> expertise;

    public ExpertiseList() {
    }

    public ExpertiseList(List<Expertise> expertise) {
        this.expertise = expertise;
    }

    public List<Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Expertise> expertise) {
        this.expertise = expertise;
    }
}
