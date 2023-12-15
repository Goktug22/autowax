package com.example.demo.repository;


import com.example.demo.model.LastikOtel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LastikOtelRepository extends JpaRepository<LastikOtel,Long > {


    @Query(value = "SELECT * FROM lastik_otel WHERE aktif = 1 Order by giris_tarih ASC ", nativeQuery = true)
    List<LastikOtel> findAllAktif();

    Optional<LastikOtel> findByOtelNo(Integer otelNo);

    @Query("SELECT MIN(e.otelNo + 1) FROM LastikOtel e WHERE NOT EXISTS (SELECT 1 FROM LastikOtel WHERE otelNo = e.otelNo + 1)")
    Optional<Integer> findFirstAvailableOtelNo();

}
