package xyz.blackmonster.resume.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.AddressRepository;
import xyz.blackmonster.resume.repository.UserContactRepository;
import xyz.blackmonster.resume.repository.UserProfileRepository;
import xyz.blackmonster.resume.repository.UserRepository;
import xyz.blackmonster.resume.repository.model.UserDAO;
import xyz.blackmonster.resume.repository.model.UserProfileDAO;
import xyz.blackmonster.resume.service.contract.PDFService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.UserBean;
import xyz.blackmonster.resume.service.model.UserProfileBean;
import xyz.blackmonster.resume.service.util.sort.EducationSort;
import xyz.blackmonster.resume.service.util.sort.JobSort;
import xyz.blackmonster.resume.service.util.sort.SkillSort;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserContactRepository userContactRepository;
    private final BeanConverter beanConverter;

    @Autowired
    public UserServiceImpl(AddressRepository addressRepository, UserRepository userRepository, UserProfileRepository userProfileRepository, UserContactRepository userContactRepository, BeanConverter beanConverter) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.userContactRepository = userContactRepository;
        this.beanConverter = beanConverter;
    }

    @Override
    public boolean hasOneUser() {
        return userRepository.count() == 1;
    }

    @Override
    public UserProfileBean getPageUserProfile() {
        List<UserDAO> users = userRepository.findAll();
        if (users.size() != 1) {
            String errorMessage = "No user set up yet.";
            LOGGER.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }

        UserDAO user = users.get(0);
        UserProfileBean userProfileBean = beanConverter.transform(user.getProfile());
        userProfileBean.getExpertise().forEach(expertiseBean -> expertiseBean.setProficient(SkillSort.sort(expertiseBean.getProficient())));

        return userProfileBean;
    }

    @Override
    public UserBean getUserByUsername(String username) {
        UserDAO userDAO = userRepository.findByUsername(username);

        return beanConverter.transform(userDAO);
    }

    @Override
    public UserBean validateCredentials(String username, String password) {
        UserDAO userDAO = userRepository.findByUsername(username);

        return beanConverter.transform(userDAO);
    }

    @Override
    public UserBean saveUser(UserBean userBean) {
        return saveOrUpdate(userBean);
    }

    @Override
    public UserBean updateUser(UserBean userBean) {
        return saveOrUpdate(userBean);
    }

    @Override
    @Transactional
    public void deleteUser() {
        String userUuid = retrieveLoggedUserUuid();
        UserDAO userDAO = userRepository.findByUuid(UUID.fromString(userUuid));
        userProfileRepository.deleteById(userDAO.getProfile().getUuid());
        userRepository.deleteById(userDAO.getUuid());
    }

    @Override
    public UserProfileBean getUserProfile() {
        String userProfileUuid = retrieveLoggedUserProfileUuid();
        UserProfileDAO userProfileDAO = userProfileRepository.findByUuid(UUID.fromString(userProfileUuid));

        UserProfileBean userProfileBean = beanConverter.transform(userProfileDAO);
        userProfileBean.setJobs(JobSort.sort(userProfileBean.getJobs()));
        userProfileBean.setEducation(EducationSort.sort(userProfileBean.getEducation()));
        userProfileBean.getExpertise().forEach(expertiseBean -> expertiseBean.setProficient(SkillSort.sort(expertiseBean.getProficient())));

        return userProfileBean;
    }

    @Override
    @Transactional
    public UserProfileBean saveUserProfile(UserProfileBean userProfileBean) {
        String userUuid = retrieveLoggedUserUuid();
        UserProfileDAO userProfileDAO = beanConverter.transform(userProfileBean);
        addressRepository.save(userProfileDAO.getAddress());
        userContactRepository.save(userProfileDAO.getUserContact());
        userProfileRepository.save(userProfileDAO);
        UserDAO userDAO = userRepository.findByUuid(UUID.fromString(userUuid));
        userDAO.setProfile(userProfileDAO);
        userRepository.save(userDAO);

        return beanConverter.transform(userProfileDAO);
    }

    @Override
    @Transactional
    public UserProfileBean updateUserProfile(String profileUuid, UserProfileBean userProfileBean) {
        UserProfileDAO currentProfile = userProfileRepository.findByUuid(UUID.fromString(profileUuid));
        if (Objects.nonNull(currentProfile)) {
            UserProfileDAO updatedProfile = beanConverter.transform(userProfileBean);
            currentProfile.setFirstname(updatedProfile.getFirstname());
            currentProfile.setLastname(updatedProfile.getLastname());
            currentProfile.setProfession(updatedProfile.getProfession());
            currentProfile.setOneLiner(updatedProfile.getOneLiner());
            currentProfile.setAboutMe(updatedProfile.getAboutMe());
            currentProfile.setBirth(updatedProfile.getBirth());
            currentProfile.setUserContact(updatedProfile.getUserContact());
            currentProfile.setAddress(updatedProfile.getAddress());

            userProfileRepository.save(currentProfile);
        }

        return beanConverter.transform(currentProfile);
    }

    @Override
    @Transactional
    public void deleteUserProfile() {
        String userUuid = retrieveLoggedUserUuid();
        userRepository.deleteById(UUID.fromString(userUuid));
    }

    @Override
    public void updatePdfLink(String profileUuid, String pdfLink) {
        UserProfileDAO userProfile = userProfileRepository.findByUuid(UUID.fromString(profileUuid));
        userProfile.setPdfLink(pdfLink);
        userProfileRepository.save(userProfile);
    }

    private UserBean saveOrUpdate(UserBean userBean) {
        UserDAO user = beanConverter.transform(userBean);
        user = userRepository.save(user);

        return beanConverter.transform(user);
    }

    private String retrieveLoggedUserUuid() {
        UserBean loggedUser = (UserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loggedUser.getUuid();
    }

    private String retrieveLoggedUserProfileUuid() {
        UserBean loggedUser = (UserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loggedUser.getUserProfile();
    }
}
