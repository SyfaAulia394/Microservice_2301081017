package com.utsmicroservice.appointment_service.controller;

import com.utsmicroservice.appointment_service.model.JanjiTemu;
import com.utsmicroservice.appointment_service.service.JanjiTemuService;

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
@RequestMapping("/api/janjitemu")
public class JanjiTemuController {

    private static final Logger log = LoggerFactory.getLogger(JanjiTemuController.class);

    @Autowired
    private JanjiTemuService janjiTemuService;

    // Endpoint untuk mengambil semua janji temu
    @GetMapping
    public List<JanjiTemu> getAllJanjiTemu() {
        log.info("GET /api/janjitemu accessed");
        return janjiTemuService.getAllJanjiTemu();
    }

    // Endpoint untuk mengambil janji temu berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<JanjiTemu> getJanjiTemuById(@PathVariable Long id) {
        log.info("GET /api/janjitemu/{} accessed", id);
        return janjiTemuService.getJanjiTemuById(id)
                .map(janjiTemu -> ResponseEntity.ok().body(janjiTemu))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint untuk membuat janji temu baru
    @PostMapping
    public JanjiTemu createJanjiTemu(@RequestBody JanjiTemu janjiTemu) {
        log.info("POST /api/janjitemu accessed with body: {}", janjiTemu);
        return janjiTemuService.createJanjiTemu(janjiTemu);
    }

    // Endpoint untuk mengupdate janji temu
    @PutMapping("/{id}")
    public ResponseEntity<JanjiTemu> updateJanjiTemu(@PathVariable Long id, @RequestBody JanjiTemu dataBaru) {
        log.info("PUT /api/janjitemu/{} accessed with body: {}", id, dataBaru);
        try {
            JanjiTemu diperbarui = janjiTemuService.updateJanjiTemu(id, dataBaru);
            return ResponseEntity.ok(diperbarui);
        } catch (RuntimeException e) {
            log.warn("PUT /api/janjitemu/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint untuk menghapus janji temu
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteJanjiTemu(@PathVariable Long id) {
        log.info("DELETE /api/janjitemu/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            janjiTemuService.deleteJanjiTemu(id);
            response.put("message", "Janji temu berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Janji temu tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/janjitemu/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}