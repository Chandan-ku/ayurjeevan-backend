package com.ayur.service;


import java.util.List;

import com.ayur.entity.Address;

public interface AddressService {
    Address saveAddress(Address address);
    List<Address> getAllAddresses();
}
