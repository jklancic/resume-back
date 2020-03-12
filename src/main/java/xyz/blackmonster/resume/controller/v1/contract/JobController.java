package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.common.Job;
import xyz.blackmonster.resume.json.v1.job.JobList;

public interface JobController {

    Job get(String uuid);

    Job addJob(Job job);

    Job updateJob(String uuid, Job job);

    void deleteJob(String uuid);

    JobList getAll();
}
