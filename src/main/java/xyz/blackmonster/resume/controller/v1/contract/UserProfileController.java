package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.user.UserProfile;

public interface UserProfileController {

    void deleteUser();

    UserProfile get();

    UserProfile addProfile(UserProfile userProfile);

    UserProfile updateProfile(String uuid, UserProfile userProfile);

    void deleteProfile();

    void publishProfile();
}
