package xyz.blackmonster.resume.json.v1.address;

import xyz.blackmonster.resume.json.v1.common.Address;

import java.util.List;

public class AddressList {

    List<Address> addresses;

    public AddressList() {
    }

    public AddressList(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
