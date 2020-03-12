package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.HomeController;
import xyz.blackmonster.resume.json.v1.user.HomeUserProfile;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.UserService;
import xyz.blackmonster.resume.service.model.UserProfileBean;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/home")
public class HomeControllerImpl implements HomeController {

    private final UserService userService;

    private final ClassConverter classConverter;

    @Autowired
    public HomeControllerImpl(UserService userService, ClassConverter classConverter) {
        this.userService = userService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public HomeUserProfile getUserProfile() {
        UserProfileBean userProfileBean = userService.getPageUserProfile();

        return classConverter.transformForHome(userProfileBean);
    }
}
