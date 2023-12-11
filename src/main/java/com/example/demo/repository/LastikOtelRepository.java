package com.example.demo.repository;

import com.example.demo.model.LastikOtel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastikOtelRepository extends JpaRepository<LastikOtel,Long > {


    @Query(value = "SELECT * FROM lastik_otel WHERE aktif = 1 Order by giris_tarih ASC ", nativeQuery = true)
    List<LastikOtel> findAllAktif();
}
