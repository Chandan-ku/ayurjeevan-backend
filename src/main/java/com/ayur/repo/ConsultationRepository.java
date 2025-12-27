package com.ayur.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayur.entity.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {}

