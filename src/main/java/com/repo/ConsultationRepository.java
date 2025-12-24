package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {}

