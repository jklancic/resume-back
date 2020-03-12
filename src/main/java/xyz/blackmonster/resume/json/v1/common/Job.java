package xyz.blackmonster.resume.json.v1.common;

import java.util.List;

public class Job {

    private String uuid;

    private String title;

    private List<JobDescription> duties;

    private String start;

    private String end;

    private Company company;

    public Job() {
    }

    public Job(String uuid, String title, List<JobDescription> duties, String start, String end, Company company) {
        this.uuid = uuid;
        this.title = title;
        this.duties = duties;
        this.start = start;
        this.end = end;
        this.company = company;
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

    public List<JobDescription> getDuties() {
        return duties;
    }

    public void setDuties(List<JobDescription> duties) {
        this.duties = duties;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
