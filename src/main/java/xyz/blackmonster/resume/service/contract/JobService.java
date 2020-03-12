package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.JobBean;

import java.util.List;

public interface JobService {

    JobBean find(String uuid);

    JobBean save(JobBean jobBean);

    JobBean update(JobBean jobBean);

    void delete(String uuid);

    List<JobBean> getAll();
}
