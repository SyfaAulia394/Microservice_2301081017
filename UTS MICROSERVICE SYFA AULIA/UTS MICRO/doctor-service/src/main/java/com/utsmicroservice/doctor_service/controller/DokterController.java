package com.utsmicroservice.doctor_service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utsmicroservice.doctor_service.model.Dokter;
import com.utsmicroservice.doctor_service.service.DokterService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dokter")
public class DokterController {

    private static final Logger log = LoggerFactory.getLogger(DokterController.class);

    @Autowired
    private DokterService dokterService;

    // Endpoint untuk mengambil semua dokter
    @GetMapping
    public List<Dokter> getAllDokter() {
        log.info("GET /api/dokter accessed");
        return dokterService.getAllDokter();
    }

    // Endpoint untuk mengambil dokter berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Dokter> getDokterById(@PathVariable Long id) {
        log.info("GET /api/dokter/{} accessed", id);
        return dokterService.getDokterById(id)
                .map(dokter -> ResponseEntity.ok().body(dokter))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint untuk membuat dokter baru
    @PostMapping
    public Dokter createDokter(@RequestBody Dokter dokter) {
        log.info("POST /api/dokter accessed with body: {}", dokter);
        return dokterService.createDokter(dokter);
    }

    // Endpoint untuk mengupdate dokter yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Dokter> updateDokter(@PathVariable Long id, @RequestBody Dokter dataDokterBaru) {
        log.info("PUT /api/dokter/{} accessed with body: {}", id, dataDokterBaru);

        try {
            Dokter dokterDiperbarui = dokterService.updateDokter(id, dataDokterBaru);
            return ResponseEntity.ok(dokterDiperbarui);
        } catch (RuntimeException e) {
            log.warn("PUT /api/dokter/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint untuk menghapus dokter
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDokter(@PathVariable Long id) {
        log.info("DELETE /api/dokter/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            dokterService.deleteDokter(id);
            response.put("message", "Dokter berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Dokter tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/dokter/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}