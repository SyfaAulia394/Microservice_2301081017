package com.utsmicroservice.doctor_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Dokter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    @Column(name = "specialization")
    private String spesialisasi;

    private String email;

    @Column(name = "phone")
    private String noHp;

    // Constructor tanpa parameter
    public Dokter() {}

    // Constructor dengan parameter
    public Dokter(String nama, String spesialisasi, String email, String noHp) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.email = email;
        this.noHp = noHp;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}