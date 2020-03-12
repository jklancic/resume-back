package xyz.blackmonster.resume.service.model.builder;

import xyz.blackmonster.resume.service.model.AddressBean;
import xyz.blackmonster.resume.service.model.EducationBean;

import java.time.LocalDate;

public class EducationBeanBuilder {

    private String uuid;

    private String title;

    private String description;

    private String institution;

    private LocalDate start;

    private LocalDate end;

    private AddressBean address;

    private boolean certification;

    private EducationBeanBuilder() {

    }

    public static EducationBeanBuilder instance() {
        return new EducationBeanBuilder();
    }

    public EducationBeanBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public EducationBeanBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EducationBeanBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EducationBeanBuilder setInstitution(String institution) {
        this.institution = institution;
        return this;
    }

    public EducationBeanBuilder setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public EducationBeanBuilder setEnd(LocalDate end) {
        this.end = end;
        return this;
    }

    public EducationBeanBuilder setAddress(AddressBean address) {
        this.address = address;
        return this;
    }

    public EducationBeanBuilder setCertification(boolean certification) {
        this.certification = certification;
        return this;
    }

    public EducationBean build() {
        return new EducationBean(uuid, title, description, institution, start, end, address, certification, null);
    }
}
