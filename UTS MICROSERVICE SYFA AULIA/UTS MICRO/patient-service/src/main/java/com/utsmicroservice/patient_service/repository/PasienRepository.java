package com.utsmicroservice.patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utsmicroservice.patient_service.model.Pasien;

@Repository
public interface PasienRepository extends JpaRepository<Pasien, Long> {
}
