package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.CompanyBean;

import java.util.List;

public interface CompanyService {

    CompanyBean find(String uuid);

    CompanyBean save(CompanyBean companyBean);

    CompanyBean update(CompanyBean companyBean);

    void delete(String uuid);

    List<CompanyBean> getAll();
}
