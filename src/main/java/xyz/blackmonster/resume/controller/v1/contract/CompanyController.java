package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.company.CompanyList;
import xyz.blackmonster.resume.json.v1.common.Company;

public interface CompanyController {

    Company get(String uuid);

    Company addCompany(Company company);

    Company updateCompany(Company company);

    void deleteCompany(String uuid);

    CompanyList getAll();
}
