package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.ExpertiseController;
import xyz.blackmonster.resume.json.v1.common.Expertise;
import xyz.blackmonster.resume.json.v1.expertise.ExpertiseList;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.ExpertiseService;
import xyz.blackmonster.resume.service.model.ExpertiseBean;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/expertise")
public class ExpertiseControllerImpl implements ExpertiseController {

    private final ExpertiseService expertiseService;

    private final ClassConverter classConverter;

    @Autowired
    public ExpertiseControllerImpl(ExpertiseService expertiseService, ClassConverter classConverter) {
        this.expertiseService = expertiseService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Expertise get(@PathVariable("uuid") String uuid) {
        ExpertiseBean expertiseBean = expertiseService.find(uuid);

        return classConverter.transform(expertiseBean);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Expertise addExpertise(@RequestBody Expertise expertise) {
        ExpertiseBean expertiseBean = classConverter.transform(expertise);
        expertiseBean = expertiseService.save(expertiseBean);

        return classConverter.transform(expertiseBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public Expertise updateExpertise(@RequestBody Expertise expertise) {
        ExpertiseBean expertiseBean = classConverter.transform(expertise);
        expertiseBean = expertiseService.update(expertiseBean);

        return classConverter.transform(expertiseBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteExpertise(@PathVariable("uuid") String uuid) {
        expertiseService.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ExpertiseList getAll() {
        List<Expertise> expertise = expertiseService.getAll()
                .stream()
                .map(classConverter::transform)
                .collect(Collectors.toList());

        return new ExpertiseList(expertise);
    }
}
