package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.EducationBean;

import java.util.List;

public interface EducationService {

    EducationBean find(String uuid);

    EducationBean save(EducationBean educationBean);

    EducationBean update(EducationBean educationBean);

    void delete(String uuid);

    List<EducationBean> getAll();
}
