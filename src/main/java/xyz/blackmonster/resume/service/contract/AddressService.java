package xyz.blackmonster.resume.service.contract;

import xyz.blackmonster.resume.service.model.AddressBean;

import java.util.List;

public interface AddressService {

    AddressBean find(String uuid);

    AddressBean save(AddressBean addressBean);

    AddressBean update(AddressBean addressBean);

    void delete(String uuid);

    List<AddressBean> getAll();
}
