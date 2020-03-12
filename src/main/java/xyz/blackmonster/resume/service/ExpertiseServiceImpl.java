package xyz.blackmonster.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.ExpertiseRepository;
import xyz.blackmonster.resume.repository.SkillRepository;
import xyz.blackmonster.resume.repository.model.ExpertiseDAO;
import xyz.blackmonster.resume.service.contract.ExpertiseService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.ExpertiseBean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

    private final ExpertiseRepository expertiseRepository;
    private final SkillRepository skillRepository;
    private final UserService userService;
    private final BeanConverter beanConverter;

    @Autowired
    public ExpertiseServiceImpl(ExpertiseRepository expertiseRepository, SkillRepository skillRepository, UserService userService, BeanConverter beanConverter) {
        this.expertiseRepository = expertiseRepository;
        this.skillRepository = skillRepository;
        this.userService = userService;
        this.beanConverter = beanConverter;
    }

    @Override
    public ExpertiseBean find(String uuid) {
        ExpertiseDAO expertise = expertiseRepository.findByUuid(UUID.fromString(uuid));

        return beanConverter.transform(expertise);
    }

    @Override
    public ExpertiseBean save(ExpertiseBean expertiseBean) {
        return saveOrUpdate(expertiseBean);
    }

    @Override
    public ExpertiseBean update(ExpertiseBean expertiseBean) {
        return saveOrUpdate(expertiseBean);
    }

    @Override
    public void delete(String uuid) {
        expertiseRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<ExpertiseBean> getAll() {
        return StreamSupport
                .stream(expertiseRepository.findAll().spliterator(), false)
                .map(beanConverter::transform)
                .collect(Collectors.toList());
    }

    private ExpertiseBean saveOrUpdate(ExpertiseBean expertiseBean) {
        expertiseBean.setUserProfile(userService.getUserProfile());

        ExpertiseDAO expertise = beanConverter.transform(expertiseBean);
        final ExpertiseDAO savedExpertise = expertiseRepository.save(expertise);
        savedExpertise.getProficient().forEach(skillDAO -> skillDAO.setExpertise(savedExpertise));
        skillRepository.saveAll(savedExpertise.getProficient());

        return beanConverter.transform(savedExpertise);
    }
}
