package xyz.blackmonster.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.CompanyRepository;
import xyz.blackmonster.resume.repository.model.CompanyDAO;
import xyz.blackmonster.resume.service.contract.AddressService;
import xyz.blackmonster.resume.service.contract.CompanyService;
import xyz.blackmonster.resume.service.model.CompanyBean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;
    private final BeanConverter beanConverter;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, AddressService addressService, BeanConverter beanConverter) {
        this.companyRepository = companyRepository;
        this.addressService = addressService;
        this.beanConverter = beanConverter;
    }

    @Override
    public CompanyBean find(String uuid) {
        CompanyDAO company = companyRepository.findByUuid(UUID.fromString(uuid));

        return beanConverter.transform(company);
    }

    @Override
    public CompanyBean save(CompanyBean companyBean) {
        return saveOrUpdate(companyBean);
    }

    @Override
    public CompanyBean update(CompanyBean companyBean) {
        return saveOrUpdate(companyBean);
    }

    @Override
    public void delete(String uuid) {
        companyRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<CompanyBean> getAll() {
        return StreamSupport
                .stream(companyRepository.findAll().spliterator(), false)
                .map(beanConverter::transform)
                .collect(Collectors.toList());
    }

    private CompanyBean saveOrUpdate(CompanyBean companyBean) {
        companyBean.setAddress(addressService.save(companyBean.getAddress()));

        CompanyDAO company = beanConverter.transform(companyBean);
        company = companyRepository.save(company);

        return beanConverter.transform(company);
    }
}
