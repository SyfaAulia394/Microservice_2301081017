package com.utsmicroservice.doctor_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsmicroservice.doctor_service.model.Dokter;
import com.utsmicroservice.doctor_service.repository.DokterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DokterService {

    @Autowired
    private DokterRepository dokterRepository;

    public List<Dokter> getAllDokter() {
        return dokterRepository.findAll();
    }

    public Optional<Dokter> getDokterById(Long id) {
        return dokterRepository.findById(id);
    }

    public Dokter createDokter(Dokter dokter) {
        return dokterRepository.save(dokter);
    }

    public Dokter updateDokter(Long id, Dokter dataBaruDokter) {
        Dokter dokter = dokterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dokter tidak ditemukan dengan id " + id));

        dokter.setNama(dataBaruDokter.getNama());
        dokter.setSpesialisasi(dataBaruDokter.getSpesialisasi());
        dokter.setEmail(dataBaruDokter.getEmail());
        dokter.setNoHp(dataBaruDokter.getNoHp());

        return dokterRepository.save(dokter);
    }

    public void deleteDokter(Long id) {
        Dokter dokter = dokterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dokter tidak ditemukan dengan id " + id));
        dokterRepository.delete(dokter);
    }
}