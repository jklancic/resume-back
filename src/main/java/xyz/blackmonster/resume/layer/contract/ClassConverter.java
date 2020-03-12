package xyz.blackmonster.resume.layer.contract;

import xyz.blackmonster.resume.json.v1.common.*;
import xyz.blackmonster.resume.json.v1.auth.User;
import xyz.blackmonster.resume.json.v1.user.HomeUserProfile;
import xyz.blackmonster.resume.json.v1.user.UserContact;
import xyz.blackmonster.resume.json.v1.user.UserProfile;
import xyz.blackmonster.resume.service.model.*;

public interface ClassConverter {

    Address transform(AddressBean addressBean);
    AddressBean transform(Address address);
    Company transform(CompanyBean companyBean);
    CompanyBean transform(Company company);
    Education transform(EducationBean educationBean);
    EducationBean transform(Education education);
    Expertise transform(ExpertiseBean expertiseBean);
    ExpertiseBean transform(Expertise expertise);
    Job transform(JobBean jobBean);
    JobBean transform(Job job);
    JobDescription transform(JobDescriptionBean jobDescriptionBean);
    JobDescriptionBean transform(JobDescription jobDescription);
    Skill transform(SkillBean skillBean);
    SkillBean transform(Skill skill);
    User transform(UserBean userBean);
    UserBean transform(User user);
    UserContact transform(UserContactBean userContactBean);
    UserContactBean transform(UserContact userContact);
    UserProfile transform(UserProfileBean userProfileBean);
    HomeUserProfile transformForHome(UserProfileBean userProfileBean);
    UserProfileBean transform(UserProfile userProfile);
}
