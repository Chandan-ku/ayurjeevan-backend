package com.ayur.controller;

import com.ayur.entity.Address;
import com.ayur.service.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAllAddresses();
    }
}
