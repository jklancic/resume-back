package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.UserProfileController;
import xyz.blackmonster.resume.json.v1.user.UserProfile;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.PDFService;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.UserProfileBean;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/profile")
public class UserProfileControllerImpl implements UserProfileController {

    private final UserService userService;

    private final PDFService pdfService;

    private final ClassConverter classConverter;

    @Autowired
    public UserProfileControllerImpl(UserService userService, PDFService pdfService, ClassConverter classConverter) {
        this.userService = userService;
        this.pdfService = pdfService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUser() {
        userService.deleteUser();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public UserProfile get() {
        return classConverter.transform(userService.getUserProfile());
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public UserProfile addProfile(@RequestBody UserProfile userProfile) {
        UserProfileBean newUserProfile = classConverter.transform(userProfile);
        UserProfileBean savedUserProfile = userService.saveUserProfile(newUserProfile);

        return classConverter.transform(savedUserProfile);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public UserProfile updateProfile(@PathVariable("uuid") String uuid, UserProfile userProfile) {
        UserProfileBean updatedUserProfile = classConverter.transform(userProfile);
        updatedUserProfile = userService.updateUserProfile(uuid, updatedUserProfile);

        return classConverter.transform(updatedUserProfile);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProfile() {
        userService.deleteUserProfile();
    }

    @Override
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void publishProfile() {
        pdfService.publishResume();
    }
}
