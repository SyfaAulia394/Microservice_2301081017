package com.teknologiinformasi.restapi.repository;
import com.teknologiinformasi.restapi.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}