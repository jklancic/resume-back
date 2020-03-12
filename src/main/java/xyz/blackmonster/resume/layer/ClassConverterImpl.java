package xyz.blackmonster.resume.layer;

import org.springframework.stereotype.Component;
import xyz.blackmonster.resume.json.v1.auth.User;
import xyz.blackmonster.resume.json.v1.common.*;
import xyz.blackmonster.resume.json.v1.user.HomeUserProfile;
import xyz.blackmonster.resume.json.v1.user.UserContact;
import xyz.blackmonster.resume.json.v1.user.UserProfile;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.model.*;
import xyz.blackmonster.resume.service.model.builder.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class ClassConverterImpl implements ClassConverter {

    private static final String FULL_DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public Address transform(AddressBean addressBean) {
        if (addressBean == null) {
            return null;
        }

        Address address = new Address();
        address.setUuid(addressBean.getUuid());
        address.setStreet(addressBean.getStreet());
        address.setPostal(addressBean.getPostal());
        address.setCity(addressBean.getCity());
        address.setCountry(addressBean.getCountry());

        return address;
    }

    @Override
    public AddressBean transform(Address address) {
        if (address == null) {
            return null;
        }

        return AddressBeanBuilder
                .instance()
                .setUuid(address.getUuid())
                .setStreet(address.getStreet())
                .setPostal(address.getPostal())
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .build();
    }

    @Override
    public Company transform(CompanyBean companyBean) {
        if (companyBean == null) {
            return null;
        }

        Company company = new Company();
        company.setUuid(companyBean.getUuid());
        company.setName(companyBean.getName());
        company.setPhone(companyBean.getPhone());
        company.setEmail(companyBean.getEmail());
        company.setAddress(transform(companyBean.getAddress()));

        return company;
    }

    @Override
    public CompanyBean transform(Company company) {
        if (company == null) {
            return null;
        }

        return CompanyBeanBuilder
                .instance()
                .setUuid(company.getUuid())
                .setName(company.getName())
                .setPhone(company.getPhone())
                .setEmail(company.getEmail())
                .setAddress(transform(company.getAddress()))
                .build();
    }

    @Override
    public Education transform(EducationBean educationBean) {
        if (educationBean == null) {
            return null;
        }

        Education education = new Education();
        education.setUuid(educationBean.getUuid());
        education.setTitle(educationBean.getTitle());
        education.setDescription(educationBean.getDescription());
        education.setInstitution(educationBean.getInstitution());
        education.setStart(educationBean.getStart().format(getDateFormatter(FULL_DATE_FORMAT)));
        education.setEnd(educationBean.getEnd().format(getDateFormatter(FULL_DATE_FORMAT)));
        education.setAddress(transform(educationBean.getAddress()));
        education.setCertification(educationBean.isCertification());

        return education;
    }

    @Override
    public EducationBean transform(Education education) {
        if (education == null) {
            return null;
        }

        return EducationBeanBuilder
                .instance()
                .setUuid(education.getUuid())
                .setTitle(education.getTitle())
                .setDescription(education.getDescription())
                .setInstitution(education.getInstitution())
                .setStart(LocalDate.parse(education.getStart(), getDateFormatter(FULL_DATE_FORMAT)))
                .setEnd(LocalDate.parse(education.getEnd(), getDateFormatter(FULL_DATE_FORMAT)))
                .setAddress(transform(education.getAddress()))
                .setCertification(education.isCertification())
                .build();
    }

    @Override
    public Expertise transform(ExpertiseBean expertiseBean) {
        if (expertiseBean == null) {
            return null;
        }

        Expertise expertise = new Expertise();
        expertise.setUuid(expertiseBean.getUuid());
        expertise.setCategory(expertiseBean.getCategory());
        expertise.setProficient(expertiseBean.getProficient().stream().map(this::transform).collect(Collectors.toList()));
        expertise.setFavorite(expertiseBean.isFavorite());

        return expertise;
    }

    @Override
    public ExpertiseBean transform(Expertise expertise) {
        if (expertise == null) {
            return null;
        }

        return ExpertiseBeanBuilder
                .instance()
                .setUuid(expertise.getUuid())
                .setCategory(expertise.getCategory())
                .setProficient(expertise.getProficient().stream().map(this::transform).collect(Collectors.toList()))
                .setFavorite(expertise.isFavorite())
                .build();
    }

    @Override
    public Job transform(JobBean jobBean) {
        if (jobBean == null) {
            return null;
        }

        Job job = new Job();
        job.setUuid(jobBean.getUuid());
        job.setTitle(jobBean.getTitle());
        job.setDuties(jobBean.getDuties().stream().map(this::transform).collect(Collectors.toList()));
        job.setStart(jobBean.getStart().format(getDateFormatter(FULL_DATE_FORMAT)));
        job.setEnd(jobBean.getEnd() != null ? jobBean.getEnd().format(getDateFormatter(FULL_DATE_FORMAT)) : null);
        job.setCompany(transform(jobBean.getCompany()));

        return job;
    }

    @Override
    public JobBean transform(Job job) {
        if (job == null) {
            return null;
        }

        return JobBeanBuilder
                .instance()
                .setUuid(job.getUuid())
                .setTitle(job.getTitle())
                .setDuties(job.getDuties().stream().map(this::transform).collect(Collectors.toSet()))
                .setStart(LocalDate.parse(job.getStart(), getDateFormatter(FULL_DATE_FORMAT)))
                .setEnd(job.getEnd() != null ? LocalDate.parse(job.getEnd(), getDateFormatter(FULL_DATE_FORMAT)) : null)
                .setCompany(transform(job.getCompany()))
                .build();
    }

    @Override
    public JobDescription transform(JobDescriptionBean jobDescriptionBean) {
        if (jobDescriptionBean == null) {
            return null;
        }

        JobDescription jobDescription = new JobDescription();
        jobDescription.setUuid(jobDescriptionBean.getUuid());
        jobDescription.setDescription(jobDescriptionBean.getDescription());

        return jobDescription;
    }

    @Override
    public JobDescriptionBean transform(JobDescription jobDescription) {
        if (jobDescription == null) {
            return null;
        }

        return JobDescriptionBeanBuilder
                .instance()
                .setUuid(jobDescription.getUuid())
                .setDescription(jobDescription.getDescription())
                .build();
    }

    @Override
    public Skill transform(SkillBean skillBean) {
        if (skillBean == null) {
            return null;
        }

        Skill skill = new Skill();
        skill.setUuid(skillBean.getUuid());
        skill.setType(skillBean.getType());
        skill.setRating(skillBean.getRating());
        skill.setScale(skillBean.getScale());

        return skill;
    }

    @Override
    public SkillBean transform(Skill skill) {
        if (skill == null) {
            return null;
        }

        return SkillBeanBuilder
                .instance()
                .setUuid(skill.getUuid())
                .setType(skill.getType())
                .setRating(skill.getRating())
                .setScale(skill.getScale())
                .build();
    }

    @Override
    public User transform(UserBean userBean) {
        if (userBean == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setPassword(userBean.getPassword());

        return user;
    }

    @Override
    public UserBean transform(User user) {
        if (user == null) {
            return null;
        }

        return UserBeanBuilder
                .instance()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .build();
    }

    @Override
    public UserContact transform(UserContactBean userContactBean) {
        if (userContactBean == null) {
            return null;
        }

        UserContact userContact = new UserContact();
        userContact.setUuid(userContactBean.getUuid());
        userContact.setPhone(userContactBean.getPhone());
        userContact.setEmail(userContactBean.getEmail());
        userContact.setWeb(userContactBean.getWeb());
        userContact.setGithub(userContactBean.getGithub());
        userContact.setLinkedin(userContactBean.getLinkedin());

        return userContact;
    }

    @Override
    public UserContactBean transform(UserContact userContact) {
        if (userContact == null) {
            return null;
        }

        return UserContactBeanBuilder
                .instance()
                .setUuid(userContact.getUuid())
                .setPhone(userContact.getPhone())
                .setEmail(userContact.getEmail())
                .setWeb(userContact.getWeb())
                .setGithub(userContact.getGithub())
                .setLinkedin(userContact.getLinkedin())
                .build();
    }

    @Override
    public UserProfile transform(UserProfileBean userProfileBean) {
        if (userProfileBean == null) {
            return null;
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setUuid(userProfileBean.getUuid());
        userProfile.setFirstname(userProfileBean.getFirstname());
        userProfile.setLastname(userProfileBean.getLastname());
        userProfile.setProfession(userProfileBean.getProfession());
        userProfile.setOneLiner(userProfileBean.getOneLiner());
        userProfile.setAboutMe(userProfileBean.getAboutMe());
        userProfile.setBirth(userProfileBean.getBirth().format(getDateFormatter(FULL_DATE_FORMAT)));
        userProfile.setUserContact(transform(userProfileBean.getUserContact()));
        userProfile.setAddress(transform(userProfileBean.getAddress()));
        userProfile.setJobs(userProfileBean.getJobs().stream().map(this::transform).collect(Collectors.toList()));
        userProfile.setEducation(userProfileBean.getEducation().stream().map(this::transform).collect(Collectors.toList()));
        userProfile.setExpertise(userProfileBean.getExpertise().stream().map(this::transform).collect(Collectors.toList()));

        return userProfile;
    }

    @Override
    public HomeUserProfile transformForHome(UserProfileBean userProfileBean) {
        if (userProfileBean == null) {
            return null;
        }

        ExpertiseBean favorite = userProfileBean.getExpertise().stream()
                .filter(ExpertiseBean::isFavorite)
                .findFirst()
                .orElse(null);

        HomeUserProfile homeUserProfile = new HomeUserProfile();
        homeUserProfile.setFirstname(userProfileBean.getFirstname());
        homeUserProfile.setLastname(userProfileBean.getLastname());
        homeUserProfile.setProfession(userProfileBean.getProfession());
        homeUserProfile.setOneLiner(userProfileBean.getOneLiner());
        homeUserProfile.setAboutMe(userProfileBean.getAboutMe());
        homeUserProfile.setBirth(userProfileBean.getBirth().format(getDateFormatter(FULL_DATE_FORMAT)));
        homeUserProfile.setPdfLink(userProfileBean.getPdfLink());
        homeUserProfile.setUserContact(transform(userProfileBean.getUserContact()));
        homeUserProfile.setFavoriteExpertise(transform(favorite));

        return homeUserProfile;
    }

    @Override
    public UserProfileBean transform(UserProfile userProfile) {
        if (userProfile == null) {
            return null;
        }

        return UserProfileBeanBuilder
                .instance()
                .setUuid(userProfile.getUuid())
                .setFirstname(userProfile.getFirstname())
                .setLastname(userProfile.getLastname())
                .setProfession(userProfile.getProfession())
                .setOneLiner(userProfile.getOneLiner())
                .setAboutMe(userProfile.getAboutMe())
                .setBirth(LocalDate.parse(userProfile.getBirth(), getDateFormatter(FULL_DATE_FORMAT)))
                .setUserContact(transform(userProfile.getUserContact()))
                .setAddress(transform(userProfile.getAddress()))
                .build();
    }

    private DateTimeFormatter getDateFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
