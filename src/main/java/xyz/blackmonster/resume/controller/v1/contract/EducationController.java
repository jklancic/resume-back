package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.common.Education;
import xyz.blackmonster.resume.json.v1.education.EducationList;

public interface EducationController {

    Education get(String uuid);

    Education addEducation(Education education);

    Education updateEducation(String uuid, Education education);

    void deleteEducation(String uuid);

    EducationList getAll();
}
