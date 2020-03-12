package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.UserBean;
import xyz.blackmonster.resume.service.model.UserProfileBean;

public interface UserService {

    boolean hasOneUser();

    UserProfileBean getPageUserProfile();

    UserBean getUserByUsername(String username);

    UserBean validateCredentials(String username, String password);

    UserBean saveUser(UserBean userBean);

    UserBean updateUser(UserBean userBean);

    void deleteUser();

    UserProfileBean getUserProfile();

    UserProfileBean saveUserProfile(UserProfileBean userProfileBean);

    UserProfileBean updateUserProfile(String profileUuid, UserProfileBean userProfileBean);

    void deleteUserProfile();

    void updatePdfLink(String userUuid, String pdfLink);
}
