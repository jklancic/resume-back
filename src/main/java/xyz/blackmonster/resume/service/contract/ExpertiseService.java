package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.ExpertiseBean;

import java.util.List;

public interface ExpertiseService {

    ExpertiseBean find(String uuid);

    ExpertiseBean save(ExpertiseBean expertiseBean);

    ExpertiseBean update(ExpertiseBean expertiseBean);

    void delete(String uuid);

    List<ExpertiseBean> getAll();
}
