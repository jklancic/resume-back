package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.JobController;
import xyz.blackmonster.resume.json.v1.common.Job;
import xyz.blackmonster.resume.json.v1.job.JobList;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.JobService;
import xyz.blackmonster.resume.service.model.JobBean;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/job")
public class JobControllerImpl implements JobController {

    private final JobService jobService;

    private final ClassConverter classConverter;

    @Autowired
    public JobControllerImpl(JobService jobService, ClassConverter classConverter) {
        this.jobService = jobService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Job get(@PathVariable("uuid") String uuid) {
        JobBean jobBean = jobService.find(uuid);

        return classConverter.transform(jobBean);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Job addJob(@RequestBody Job job) {
        JobBean jobBean = classConverter.transform(job);
        jobBean = jobService.save(jobBean);

        return classConverter.transform(jobBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public Job updateJob(@PathVariable("uuid") String uuid, @RequestBody Job job) {
        if (!uuid.equals(job.getUuid())) {
            throw new IllegalStateException("Uuid does not match");
        }

        JobBean jobBean = classConverter.transform(job);
        jobBean = jobService.update(jobBean);

        return classConverter.transform(jobBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteJob(@PathVariable("uuid") String uuid) {
        jobService.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public JobList getAll() {
        List<Job> jobs = jobService.getAll()
                .stream()
                .map(classConverter::transform)
                .collect(Collectors.toList());

        return new JobList(jobs);
    }
}
