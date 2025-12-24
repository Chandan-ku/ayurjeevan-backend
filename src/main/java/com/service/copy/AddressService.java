package com.service.copy;


import java.util.List;

import com.entity.Address;

public interface AddressService {
    Address saveAddress(Address address);
    List<Address> getAllAddresses();
}
