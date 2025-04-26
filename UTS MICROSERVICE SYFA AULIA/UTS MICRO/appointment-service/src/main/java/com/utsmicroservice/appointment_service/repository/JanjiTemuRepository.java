package com.utsmicroservice.appointment_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utsmicroservice.appointment_service.model.JanjiTemu;

@Repository
public interface JanjiTemuRepository extends JpaRepository<JanjiTemu, Long> {
}