package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.EducationController;
import xyz.blackmonster.resume.json.v1.common.Education;
import xyz.blackmonster.resume.json.v1.education.EducationList;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.EducationService;
import xyz.blackmonster.resume.service.model.EducationBean;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/education")
public class EducationControllerImpl implements EducationController {

    private final EducationService educationService;

    private final ClassConverter classConverter;

    @Autowired
    public EducationControllerImpl(EducationService educationService, ClassConverter classConverter) {
        this.educationService = educationService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Education get(@PathVariable("uuid") String uuid) {
        EducationBean educationBean = educationService.find(uuid);

        return classConverter.transform(educationBean);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Education addEducation(@RequestBody Education education) {
        EducationBean educationBean = classConverter.transform(education);
        educationBean = educationService.save(educationBean);

        return classConverter.transform(educationBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public Education updateEducation(@PathVariable("uuid") String uuid, @RequestBody Education education) {
        if (!uuid.equals(education.getUuid())) {
            throw new IllegalStateException("Uuid does not match");
        }

        EducationBean educationBean = classConverter.transform(education);
        educationBean = educationService.update(educationBean);

        return classConverter.transform(educationBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteEducation(@PathVariable("uuid") String uuid) {
        educationService.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public EducationList getAll() {
        List<Education> education = educationService.getAll()
                .stream()
                .map(classConverter::transform)
                .collect(Collectors.toList());

        return new EducationList(education);
    }
}
