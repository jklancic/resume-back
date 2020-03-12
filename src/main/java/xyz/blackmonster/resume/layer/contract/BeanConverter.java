package xyz.blackmonster.resume.layer.contract;

import xyz.blackmonster.resume.repository.model.*;
import xyz.blackmonster.resume.service.model.*;

public interface BeanConverter {

    AddressBean transform(AddressDAO addressDAO);
    AddressDAO transform(AddressBean addressBean);
    CompanyBean transform(CompanyDAO companyDAO);
    CompanyDAO transform(CompanyBean companyBean);
    EducationBean transform(EducationDAO educationDAO);
    EducationDAO transform(EducationBean educationBean);
    ExpertiseBean transform(ExpertiseDAO expertiseDAO);
    ExpertiseDAO transform(ExpertiseBean expertiseBean);
    JobBean transform(JobDAO jobDAO);
    JobDAO transform(JobBean jobBean);
    JobDescriptionBean transform(JobDescriptionDAO jobDescriptionDAO);
    JobDescriptionDAO transform(JobDescriptionBean jobDescriptionBean);
    SkillBean transform(SkillDAO skillDAO);
    SkillDAO transform(SkillBean skillBean);
    UserBean transform(UserDAO userDAO);
    UserDAO transform(UserBean userBean);
    UserContactBean transform(UserContactDAO userContactDAO);
    UserContactDAO transform(UserContactBean userContactBean);
    UserProfileBean transform(UserProfileDAO userProfileDAO);
    UserProfileDAO transform(UserProfileBean userProfileBean);
}
