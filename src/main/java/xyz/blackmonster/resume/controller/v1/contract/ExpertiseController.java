package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.common.Expertise;
import xyz.blackmonster.resume.json.v1.expertise.ExpertiseList;

public interface ExpertiseController {

    Expertise get(String uuid);

    Expertise addExpertise(Expertise expertise);

    Expertise updateExpertise(Expertise expertise);

    void deleteExpertise(String uuid);

    ExpertiseList getAll();
}
