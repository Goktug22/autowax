package com.example.demo.repository;

import com.example.demo.model.Harcama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HarcamaRepository extends JpaRepository<Harcama,Long > {

    List<Harcama> findAllByTarihBetween(Date startDate, Date endDate);


}
