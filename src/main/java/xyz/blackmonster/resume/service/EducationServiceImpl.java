package xyz.blackmonster.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.EducationRepository;
import xyz.blackmonster.resume.repository.model.EducationDAO;
import xyz.blackmonster.resume.service.contract.AddressService;
import xyz.blackmonster.resume.service.contract.EducationService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.EducationBean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final AddressService addressService;
    private final UserService userService;
    private final BeanConverter beanConverter;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository, AddressService addressService, UserService userService, BeanConverter beanConverter) {
        this.educationRepository = educationRepository;
        this.addressService = addressService;
        this.userService = userService;
        this.beanConverter = beanConverter;
    }

    @Override
    public EducationBean find(String uuid) {
        EducationDAO education = educationRepository.findByUuid(UUID.fromString(uuid));

        return beanConverter.transform(education);
    }

    @Override
    public EducationBean save(EducationBean educationBean) {
        educationBean.setUserProfile(userService.getUserProfile());

        return saveOrUpdate(educationBean);
    }

    @Override
    public EducationBean update(EducationBean educationBean) {
        return null;
    }

    @Override
    public void delete(String uuid) {
        educationRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<EducationBean> getAll() {
        return StreamSupport
                .stream(educationRepository.findAll().spliterator(), false)
                .map(beanConverter::transform)
                .collect(Collectors.toList());
    }

    private EducationBean saveOrUpdate(EducationBean educationBean) {
        educationBean.setAddress(addressService.save(educationBean.getAddress()));
        educationBean.setUserProfile(userService.getUserProfile());

        EducationDAO education = beanConverter.transform(educationBean);
        education = educationRepository.save(education);

        return beanConverter.transform(education);
    }
}
