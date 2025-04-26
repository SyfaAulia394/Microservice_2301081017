package com.utsmicroservice.appointment_service.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "janji_temu")
public class JanjiTemu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pasien")
    private Long idPasien;

    @Column(name = "id_dokter")
    private Long idDokter;

    @Column(name = "tanggal_janji")
    private LocalDateTime tanggalJanji;

    private String deskripsi;

    // Constructor tanpa parameter
    public JanjiTemu() {}

    // Constructor dengan parameter
    public JanjiTemu(Long idPasien, Long idDokter, LocalDateTime tanggalJanji, String deskripsi) {
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggalJanji = tanggalJanji;
        this.deskripsi = deskripsi;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
    }

    public LocalDateTime getTanggalJanji() {
        return tanggalJanji;
    }

    public void setTanggalJanji(LocalDateTime tanggalJanji) {
        this.tanggalJanji = tanggalJanji;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
