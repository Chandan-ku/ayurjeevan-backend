package com.ayur.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayur.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

