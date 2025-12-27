package com.ayur.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayur.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

