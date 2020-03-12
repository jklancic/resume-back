package xyz.blackmonster.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.JobDescriptionRepository;
import xyz.blackmonster.resume.repository.JobRepository;
import xyz.blackmonster.resume.repository.model.JobDAO;
import xyz.blackmonster.resume.service.contract.CompanyService;
import xyz.blackmonster.resume.service.contract.JobService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.JobBean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobDescriptionRepository jobDescriptionRepository;
    private final CompanyService companyService;
    private final UserService userService;
    private final BeanConverter beanConverter;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, JobDescriptionRepository jobDescriptionRepository, CompanyService companyService, UserService userService, BeanConverter beanConverter) {
        this.jobRepository = jobRepository;
        this.jobDescriptionRepository = jobDescriptionRepository;
        this.companyService = companyService;
        this.userService = userService;
        this.beanConverter = beanConverter;
    }

    @Override
    public JobBean find(String uuid) {
        JobDAO job = jobRepository.findByUuid(UUID.fromString(uuid));

        return beanConverter.transform(job);
    }

    @Override
    public JobBean save(JobBean jobBean) {
        return saveOrUpdate(jobBean);
    }

    @Override
    public JobBean update(JobBean jobBean) {
        return saveOrUpdate(jobBean);
    }

    @Override
    public void delete(String uuid) {
        jobRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<JobBean> getAll() {
        return StreamSupport
                .stream(jobRepository.findAll().spliterator(), false)
                .map(beanConverter::transform)
                .collect(Collectors.toList());
    }

    private JobBean saveOrUpdate(JobBean jobBean) {
        jobBean.setUserProfile(userService.getUserProfile());
        jobBean.setCompany(companyService.save(jobBean.getCompany()));

        JobDAO job = beanConverter.transform(jobBean);
        final JobDAO savedJob = jobRepository.save(job);
        savedJob.getDuties().forEach(jobDescriptionDAO -> jobDescriptionDAO.setJob(savedJob));
        jobDescriptionRepository.saveAll(savedJob.getDuties());

        return beanConverter.transform(savedJob);
    }
}
