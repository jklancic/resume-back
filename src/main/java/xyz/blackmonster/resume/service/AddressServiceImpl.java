package xyz.blackmonster.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blackmonster.resume.layer.contract.BeanConverter;
import xyz.blackmonster.resume.repository.AddressRepository;
import xyz.blackmonster.resume.repository.model.AddressDAO;
import xyz.blackmonster.resume.service.contract.AddressService;
import xyz.blackmonster.resume.service.model.AddressBean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final BeanConverter beanConverter;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, BeanConverter beanConverter) {
        this.addressRepository = addressRepository;
        this.beanConverter = beanConverter;
    }

    @Override
    public AddressBean find(String uuid) {
        AddressDAO address = addressRepository.findByUuid(UUID.fromString(uuid));

        return beanConverter.transform(address);
    }

    @Override
    public AddressBean save(AddressBean addressBean) {
        return saveOrUpdate(addressBean);
    }

    @Override
    public AddressBean update(AddressBean addressBean) {
        return saveOrUpdate(addressBean);
    }

    @Override
    public void delete(String uuid) {
        addressRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<AddressBean> getAll() {
        return StreamSupport
                .stream(addressRepository.findAll().spliterator(), false)
                .map(beanConverter::transform)
                .collect(Collectors.toList());
    }

    private AddressBean saveOrUpdate(AddressBean addressBean) {
        AddressDAO address = beanConverter.transform(addressBean);
        address = addressRepository.save(address);

        return beanConverter.transform(address);
    }
}
