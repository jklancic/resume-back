package xyz.blackmonster.resume.controller.v1.contract;

import xyz.blackmonster.resume.json.v1.address.AddressList;
import xyz.blackmonster.resume.json.v1.common.Address;

public interface AddressController {

    Address get(String uuid);

    Address addAddress(Address address);

    Address updateAddress(Address address);

    void deleteExpertise(String uuid);

    AddressList getAll();
}
