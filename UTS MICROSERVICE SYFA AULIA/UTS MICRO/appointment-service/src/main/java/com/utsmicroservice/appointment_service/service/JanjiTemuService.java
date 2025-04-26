package com.utsmicroservice.appointment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsmicroservice.appointment_service.model.JanjiTemu;
import com.utsmicroservice.appointment_service.repository.JanjiTemuRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JanjiTemuService {

    @Autowired
    private JanjiTemuRepository janjiTemuRepository;

    public List<JanjiTemu> getAllJanjiTemu() {
        return janjiTemuRepository.findAll();
    }

    public Optional<JanjiTemu> getJanjiTemuById(Long id) {
        return janjiTemuRepository.findById(id);
    }

    public JanjiTemu createJanjiTemu(JanjiTemu janjiTemu) {
        return janjiTemuRepository.save(janjiTemu);
    }

    public JanjiTemu updateJanjiTemu(Long id, JanjiTemu dataBaruJanjiTemu) {
        JanjiTemu janjiTemu = janjiTemuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Janji Temu tidak ditemukan dengan id " + id));

        janjiTemu.setIdPasien(dataBaruJanjiTemu.getIdPasien());
        janjiTemu.setIdDokter(dataBaruJanjiTemu.getIdDokter());
        janjiTemu.setTanggalJanji(dataBaruJanjiTemu.getTanggalJanji());
        janjiTemu.setDeskripsi(dataBaruJanjiTemu.getDeskripsi());

        return janjiTemuRepository.save(janjiTemu);
    }

    public void deleteJanjiTemu(Long id) {
        JanjiTemu janjiTemu = janjiTemuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Janji Temu tidak ditemukan dengan id " + id));
        janjiTemuRepository.delete(janjiTemu);
    }
}
