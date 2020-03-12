package xyz.blackmonster.resume.json.v1.company;

import xyz.blackmonster.resume.json.v1.common.Company;

import java.util.List;

public class CompanyList {

    List<Company> companies;

    public CompanyList() {
    }

    public CompanyList(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
