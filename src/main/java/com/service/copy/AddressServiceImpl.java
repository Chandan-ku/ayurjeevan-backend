package com.service.copy;



import org.springframework.stereotype.Service;

import com.entity.Address;
import com.repo.AddressRepository;

import java.util.List;

@Service   // 🔹 This is very important
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}
}
