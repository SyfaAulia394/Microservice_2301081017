package com.utsmicroservice.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utsmicroservice.doctor_service.model.Dokter;

@Repository
public interface DokterRepository extends JpaRepository<Dokter, Long> {
}
