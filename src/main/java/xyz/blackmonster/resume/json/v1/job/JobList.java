package xyz.blackmonster.resume.json.v1.job;

import xyz.blackmonster.resume.json.v1.common.Job;

import java.util.List;

public class JobList {

    private List<Job> jobs;

    public JobList() {
    }

    public JobList(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
