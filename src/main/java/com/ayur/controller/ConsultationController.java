package com.ayur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayur.entity.Consultation;
import com.ayur.repo.ConsultationRepository;

@RestController
@RequestMapping("/api/consultation")
@CrossOrigin(origins = "*")
public class ConsultationController {
    
    @Autowired
    private ConsultationRepository repo;

    @PostMapping
    public ResponseEntity<String> submitConsultation(@RequestBody Consultation consult) {
        repo.save(consult);
        return ResponseEntity.ok("Consultation submitted successfully.");
    }

    @GetMapping
    public List<Consultation> getAllConsultations() {
        return repo.findAll();
    }

    // ✅ Optional: Test endpoint
    @GetMapping("/ping")
    public String test() {
        return "Consultation API working ✅";
    }
}
