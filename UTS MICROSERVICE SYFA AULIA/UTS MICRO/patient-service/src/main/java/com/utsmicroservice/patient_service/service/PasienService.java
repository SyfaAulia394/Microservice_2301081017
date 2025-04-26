package com.utsmicroservice.patient_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsmicroservice.patient_service.model.Pasien;
import com.utsmicroservice.patient_service.repository.PasienRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PasienService {

    @Autowired
    private PasienRepository pasienRepository;

    public List<Pasien> getAllPasien() {
        return pasienRepository.findAll();
    }

    public Optional<Pasien> getPasienById(Long id) {
        return pasienRepository.findById(id);
    }

    public Pasien createPasien(Pasien pasien) {
        return pasienRepository.save(pasien);
    }

    public Pasien updatePasien(Long id, Pasien dataBaruPasien) {
        Pasien pasien = pasienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasien tidak ditemukan dengan id " + id));
        
        pasien.setNama(dataBaruPasien.getNama());
        pasien.setJenisKelamin(dataBaruPasien.getJenisKelamin());
        pasien.setTanggalLahir(dataBaruPasien.getTanggalLahir());
        pasien.setNoHp(dataBaruPasien.getNoHp());
        pasien.setAlamat(dataBaruPasien.getAlamat());

        return pasienRepository.save(pasien);
    }

    public void deletePasien(Long id) {
        Pasien pasien = pasienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasien tidak ditemukan dengan id " + id));
        pasienRepository.delete(pasien);
    }
}
