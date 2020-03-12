package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.CompanyBean;
import xyz.blackmonster.resume.service.model.JobBean;
import xyz.blackmonster.resume.service.model.JobDescriptionBean;

import java.time.LocalDate;
import java.util.Set;

public class JobBeanBuilder {

    private String uuid;

    private String title;

    private Set<JobDescriptionBean> duties;

    private LocalDate start;

    private LocalDate end;

    private CompanyBean company;

    private JobBeanBuilder() {

    }

    public static JobBeanBuilder instance() {
        return new JobBeanBuilder();
    }

    public JobBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public JobBeanBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public JobBeanBuilder setDuties(Set<JobDescriptionBean> duties) {
        this.duties = duties;
        return this;
    }

    public JobBeanBuilder setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public JobBeanBuilder setEnd(LocalDate end) {
        this.end = end;
        return this;
    }

    public JobBeanBuilder setCompany(CompanyBean company) {
        this.company = company;
        return this;
    }

    public JobBean build() {
        return new JobBean(uuid, title, duties, start, end, company, null);
    }
}
