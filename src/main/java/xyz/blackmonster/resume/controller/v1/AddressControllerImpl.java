package xyz.blackmonster.resume.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.blackmonster.resume.controller.ApiVersioning;
import xyz.blackmonster.resume.controller.v1.contract.AddressController;
import xyz.blackmonster.resume.json.v1.address.AddressList;
import xyz.blackmonster.resume.json.v1.common.Address;
import xyz.blackmonster.resume.layer.contract.ClassConverter;
import xyz.blackmonster.resume.service.contract.AddressService;
import xyz.blackmonster.resume.service.model.AddressBean;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiVersioning.API_V1 + "/address")
public class AddressControllerImpl implements AddressController {

    private final AddressService addressService;

    private final ClassConverter classConverter;

    @Autowired
    public AddressControllerImpl(AddressService addressService, ClassConverter classConverter) {
        this.addressService = addressService;
        this.classConverter = classConverter;
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Address get(@PathVariable("uuid") String uuid) {
        AddressBean addressBean = addressService.find(uuid);

        return classConverter.transform(addressBean);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Address addAddress(@RequestBody Address address) {
        AddressBean addressBean = classConverter.transform(address);
        addressBean = addressService.save(addressBean);

        return classConverter.transform(addressBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public Address updateAddress(@RequestBody Address address) {
        AddressBean addressBean = classConverter.transform(address);
        addressBean = addressService.update(addressBean);

        return classConverter.transform(addressBean);
    }

    @Override
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteExpertise(String uuid) {
        addressService.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public AddressList getAll() {
        List<Address> addresses = addressService.getAll()
                .stream()
                .map(classConverter::transform)
                .collect(Collectors.toList());

        return new AddressList(addresses);
    }
}
