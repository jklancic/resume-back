package xyz.blackmonster.resume.layer;

import org.springframework.stereotype.Component;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.model.*;
import xyz.blackmonster.resume.repository.model.builder.*;
import xyz.blackmonster.resume.service.model.*;
import xyz.blackmonster.resume.service.model.builder.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BeanConverterImpl implements BeanConverter {

    @Override
    public AddressBean transform(AddressDAO addressDAO) {
        if (addressDAO == null) {
            return null;
        }

        return AddressBeanBuilder
                .instance()
                .setUuid(addressDAO.getUuid() != null ? addressDAO.getUuid().toString() : null)
                .setStreet(addressDAO.getStreet())
                .setCity(addressDAO.getCity())
                .setPostal(addressDAO.getPostal())
                .setCountry(addressDAO.getCountry())
                .build();
    }

    @Override
    public AddressDAO transform(AddressBean addressBean) {
        if (addressBean == null) {
            return null;
        }

        return AddressDAOBuilder
                .instance()
                .setUuid(addressBean.getUuid() != null ? UUID.fromString(addressBean.getUuid()) : null)
                .setStreet(addressBean.getStreet())
                .setCity(addressBean.getCity())
                .setPostal(addressBean.getPostal())
                .setCountry(addressBean.getCountry())
                .build();
    }

    @Override
    public CompanyBean transform(CompanyDAO companyDAO) {
        if (companyDAO == null) {
            return null;
        }

        return CompanyBeanBuilder
                .instance()
                .setUuid(companyDAO.getUuid() != null ? companyDAO.getUuid().toString() : null)
                .setName(companyDAO.getName())
                .setPhone(companyDAO.getPhone())
                .setEmail(companyDAO.getEmail())
                .setAddress(transform(companyDAO.getAddress()))
                .build();
    }

    @Override
    public CompanyDAO transform(CompanyBean companyBean) {
        if (companyBean == null) {
            return null;
        }

        return CompanyDAOBuilder
                .instance()
                .setUuid(companyBean.getUuid() != null ? UUID.fromString(companyBean.getUuid()) : null)
                .setName(companyBean.getName())
                .setPhone(companyBean.getPhone())
                .setEmail(companyBean.getEmail())
                .setAddress(transform(companyBean.getAddress()))
                .build();
    }

    @Override
    public EducationBean transform(EducationDAO educationDAO) {
        if (educationDAO == null) {
            return null;
        }

        return EducationBeanBuilder
                .instance()
                .setUuid(educationDAO.getUuid() != null ? educationDAO.getUuid().toString() : null)
                .setTitle(educationDAO.getTitle())
                .setDescription(educationDAO.getDescription())
                .setInstitution(educationDAO.getInstitution())
                .setStart(educationDAO.getStartTime())
                .setEnd(educationDAO.getEndTime())
                .setCertification(educationDAO.isCertification())
                .setAddress(transform(educationDAO.getAddress()))
                .build();
    }

    @Override
    public EducationDAO transform(EducationBean educationBean) {
        if (educationBean == null) {
            return null;
        }

        return EducationDAOBuilder
                .instance()
                .setUuid(educationBean.getUuid() != null ? UUID.fromString(educationBean.getUuid()) : null)
                .setTitle(educationBean.getTitle())
                .setDescription(educationBean.getDescription())
                .setInstitution(educationBean.getInstitution())
                .setStart(educationBean.getStart())
                .setEnd(educationBean.getEnd())
                .setCertification(educationBean.isCertification())
                .setAddress(transform(educationBean.getAddress()))
                .setUserProfile(transform(educationBean.getUserProfile()))
                .build();
    }

    @Override
    public ExpertiseBean transform(ExpertiseDAO expertiseDAO) {
        if (expertiseDAO == null) {
            return null;
        }

        return ExpertiseBeanBuilder
                .instance()
                .setUuid(expertiseDAO.getUuid() != null ? expertiseDAO.getUuid().toString() : null)
                .setCategory(expertiseDAO.getCategory())
                .setProficient(expertiseDAO.getProficient().stream().map(this::transform).collect(Collectors.toList()))
                .setFavorite(expertiseDAO.getFavorite())
                .build();
    }

    @Override
    public ExpertiseDAO transform(ExpertiseBean expertiseBean) {
        if (expertiseBean == null) {
            return null;
        }

        return ExpertiseDAOBuilder
                .instance()
                .setUuid(expertiseBean.getUuid() != null ? UUID.fromString(expertiseBean.getUuid()) : null)
                .setCategory(expertiseBean.getCategory())
                .setProficient(expertiseBean.getProficient().stream().map(this::transform).collect(Collectors.toSet()))
                .setUserProfile(transform(expertiseBean.getUserProfile()))
                .setFavorite(expertiseBean.isFavorite())
                .build();
    }

    @Override
    public JobBean transform(JobDAO jobDAO) {
        if (jobDAO == null) {
            return null;
        }

        return JobBeanBuilder
                .instance()
                .setUuid(jobDAO.getUuid() != null ? jobDAO.getUuid().toString() : null)
                .setTitle(jobDAO.getTitle())
                .setDuties(jobDAO.getDuties().stream().map(this::transform).collect(Collectors.toSet()))
                .setStart(jobDAO.getStartTime())
                .setEnd(jobDAO.getEndTime())
                .setCompany(transform(jobDAO.getCompany()))
                .build();
    }

    @Override
    public JobDAO transform(JobBean jobBean) {
        if (jobBean == null) {
            return null;
        }

        return JobDAOBuilder
                .instance()
                .setUuid(jobBean.getUuid() != null ? UUID.fromString(jobBean.getUuid()) : null)
                .setTitle(jobBean.getTitle())
                .setDuties(jobBean.getDuties().stream().map(this::transform).collect(Collectors.toSet()))
                .setStart(jobBean.getStart())
                .setEnd(jobBean.getEnd())
                .setCompany(transform(jobBean.getCompany()))
                .setUserProfile(transform(jobBean.getUserProfile()))
                .build();
    }

    @Override
    public JobDescriptionBean transform(JobDescriptionDAO jobDescriptionDAO) {
        if (jobDescriptionDAO == null) {
            return null;
        }

        return JobDescriptionBeanBuilder
                .instance()
                .setUuid(jobDescriptionDAO.getUuid() != null ? jobDescriptionDAO.getUuid().toString() : null)
                .setDescription(jobDescriptionDAO.getDescription())
                .build();
    }

    @Override
    public JobDescriptionDAO transform(JobDescriptionBean jobDescriptionBean) {
        if (jobDescriptionBean == null) {
            return null;
        }

        return JobDescriptionDAOBuilder
                .instance()
                .setUuid(jobDescriptionBean.getUuid() != null ? UUID.fromString(jobDescriptionBean.getUuid()) : null)
                .setDescription(jobDescriptionBean.getDescription())
                .build();
    }

    @Override
    public SkillBean transform(SkillDAO skillDAO) {
        if (skillDAO == null) {
            return null;
        }

        return SkillBeanBuilder
                .instance()
                .setUuid(skillDAO.getUuid() != null ? skillDAO.getUuid().toString() : null)
                .setType(skillDAO.getType())
                .setRating(skillDAO.getRating())
                .setScale(skillDAO.getScale())
                .build();
    }

    @Override
    public SkillDAO transform(SkillBean skillBean) {
        if (skillBean == null) {
            return null;
        }

        return SkillDAOBuilder
                .instance()
                .setUuid(skillBean.getUuid() != null ? UUID.fromString(skillBean.getUuid()) : null)
                .setType(skillBean.getType())
                .setRating(skillBean.getRating())
                .setScale(skillBean.getScale())
                .build();
    }

    @Override
    public UserBean transform(UserDAO userDAO) {
        if (userDAO == null) {
            return null;
        }

        return UserBeanBuilder
                .instance()
                .setUuid(userDAO.getUuid() != null ? userDAO.getUuid().toString() : null)
                .setUsername(userDAO.getUsername())
                .setPassword(userDAO.getPassword())
                .setUserProfile(userDAO.getProfile() != null ? userDAO.getProfile().getUuid().toString() : null)
                .build();
    }

    @Override
    public UserDAO transform(UserBean userBean) {
        if (userBean == null) {
            return null;
        }

        return UserDAOBuilder
                .instance()
                .setUuid(userBean.getUuid() != null ? UUID.fromString(userBean.getUuid()) : null)
                .setUsername(userBean.getUsername())
                .setPassword(userBean.getPassword())
                .build();
    }

    @Override
    public UserContactBean transform(UserContactDAO userContactDAO) {
        if (userContactDAO == null) {
            return null;
        }

        return UserContactBeanBuilder
                .instance()
                .setUuid(userContactDAO.getUuid() != null ? userContactDAO.getUuid().toString() : null)
                .setPhone(userContactDAO.getPhone())
                .setEmail(userContactDAO.getEmail())
                .setWeb(userContactDAO.getWeb())
                .setGithub(userContactDAO.getGithub())
                .setLinkedin(userContactDAO.getLinkedin())
                .build();
    }

    @Override
    public UserContactDAO transform(UserContactBean userContactBean) {
        if (userContactBean == null) {
            return null;
        }

        return UserContactDAOBuilder
                .instance()
                .setUuid(userContactBean.getUuid() != null ? UUID.fromString(userContactBean.getUuid()) : null)
                .setPhone(userContactBean.getPhone())
                .setEmail(userContactBean.getEmail())
                .setWeb(userContactBean.getWeb())
                .setGithub(userContactBean.getGithub())
                .setLinkedin(userContactBean.getLinkedin())
                .build();
    }

    @Override
    public UserProfileBean transform(UserProfileDAO userProfileDAO) {
        if (userProfileDAO == null) {
            return null;
        }

        return UserProfileBeanBuilder
                .instance()
                .setUuid(userProfileDAO.getUuid() != null ? userProfileDAO.getUuid().toString() : null)
                .setFirstname(userProfileDAO.getFirstname())
                .setLastname(userProfileDAO.getLastname())
                .setProfession(userProfileDAO.getProfession())
                .setOneLiner(userProfileDAO.getOneLiner())
                .setAboutMe(userProfileDAO.getAboutMe())
                .setBirth(userProfileDAO.getBirth())
                .setPdfLink(userProfileDAO.getPdfLink())
                .setUserContact(transform(userProfileDAO.getUserContact()))
                .setAddress(transform(userProfileDAO.getAddress()))
                .setJobs(userProfileDAO.getJobs().stream().map(this::transform).collect(Collectors.toList()))
                .setEducation(userProfileDAO.getEducation().stream().map(this::transform).collect(Collectors.toList()))
                .setExpertise(userProfileDAO.getExpertise().stream().map(this::transform).collect(Collectors.toList()))
                .build();
    }

    @Override
    public UserProfileDAO transform(UserProfileBean userProfileBean) {
        if (userProfileBean == null) {
            return null;
        }

        return UserProfileDAOBuilder
                .instance()
                .setUuid(userProfileBean.getUuid() != null ? UUID.fromString(userProfileBean.getUuid()) : null)
                .setFirstname(userProfileBean.getFirstname())
                .setLastname(userProfileBean.getLastname())
                .setProfession(userProfileBean.getProfession())
                .setOneLiner(userProfileBean.getOneLiner())
                .setAboutMe(userProfileBean.getAboutMe())
                .setBirth(userProfileBean.getBirth())
                .setPdfLink(userProfileBean.getPdfLink())
                .setUserContact(transform(userProfileBean.getUserContact()))
                .setAddress(transform(userProfileBean.getAddress()))
                .setJobs(convertToJobDAO(userProfileBean.getJobs()))
                .setEducation(convertToEducationDAO(userProfileBean.getEducation()))
                .setExpertise(convertToExpertiseDAO(userProfileBean.getExpertise()))
                .build();
    }

    private Set<JobDAO> convertToJobDAO(List<JobBean> jobBeans) {
        if (jobBeans == null) {
            return new HashSet<>();
        }

        return jobBeans.stream().map(this::transform).collect(Collectors.toSet());
    }

    private Set<EducationDAO> convertToEducationDAO(List<EducationBean> educationBeans) {
        if (educationBeans == null) {
            return new HashSet<>();
        }

        return educationBeans.stream().map(this::transform).collect(Collectors.toSet());
    }

    private Set<ExpertiseDAO> convertToExpertiseDAO(List<ExpertiseBean> jobBeans) {
        if (jobBeans == null) {
            return new HashSet<>();
        }

        return jobBeans.stream().map(this::transform).collect(Collectors.toSet());
    }
}
