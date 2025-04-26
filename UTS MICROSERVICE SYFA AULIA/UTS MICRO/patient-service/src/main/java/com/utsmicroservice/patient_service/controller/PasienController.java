package com.utsmicroservice.patient_service.controller;

import com.utsmicroservice.patient_service.model.Pasien;
import com.utsmicroservice.patient_service.service.PasienService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pasien")
public class PasienController {

    private static final Logger log = LoggerFactory.getLogger(PasienController.class);

    @Autowired
    private PasienService pasienService;

    // Endpoint untuk mengambil semua pasien
    @GetMapping
    public List<Pasien> getAllPasien() {
        log.info("GET /api/pasien accessed");
        return pasienService.getAllPasien();
    }

    // Endpoint untuk mengambil pasien berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Pasien> getPasienById(@PathVariable Long id) {
        log.info("GET /api/pasien/{} accessed", id);
        return pasienService.getPasienById(id)
                .map(pasien -> ResponseEntity.ok().body(pasien))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint untuk membuat pasien baru
    @PostMapping
    public Pasien createPasien(@RequestBody Pasien pasien) {
        log.info("POST /api/pasien accessed with body: {}", pasien);
        return pasienService.createPasien(pasien);
    }

    // Endpoint untuk mengupdate pasien yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Pasien> updatePasien(@PathVariable Long id, @RequestBody Pasien dataPasienBaru) {
        log.info("PUT /api/pasien/{} accessed with body: {}", id, dataPasienBaru);

        try {
            Pasien pasienDiperbarui = pasienService.updatePasien(id, dataPasienBaru);
            return ResponseEntity.ok(pasienDiperbarui);
        } catch (RuntimeException e) {
            log.warn("PUT /api/pasien/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint untuk menghapus pasien
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePasien(@PathVariable Long id) {
        log.info("DELETE /api/pasien/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            pasienService.deletePasien(id);
            response.put("message", "Pasien berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Pasien tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/pasien/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}