package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.CompanyController;
import xyz.blackmonster.resume.json.v1.common.Company;
import xyz.blackmonster.resume.json.v1.company.CompanyList;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.CompanyService;
import xyz.blackmonster.resume.service.model.CompanyBean;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/company")
public class CompanyControllerImpl implements CompanyController {

    private final CompanyService companyService;

    private final ClassConverter classConverter;

    @Autowired
    public CompanyControllerImpl(CompanyService companyService, ClassConverter classConverter) {
        this.companyService = companyService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Company get(String uuid) {
        CompanyBean companyBean = companyService.find(uuid);

        return classConverter.transform(companyBean);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Company addCompany(@RequestBody Company company) {
        CompanyBean companyBean = classConverter.transform(company);
        companyBean = companyService.save(companyBean);

        return classConverter.transform(companyBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public Company updateCompany(@RequestBody Company company) {
        CompanyBean companyBean = classConverter.transform(company);
        companyBean = companyService.update(companyBean);

        return classConverter.transform(companyBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCompany(String uuid) {
        companyService.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public CompanyList getAll() {
        List<Company> jobs = companyService.getAll()
                .stream()
                .map(classConverter::transform)
                .collect(Collectors.toList());

        return new CompanyList(jobs);
    }
}
