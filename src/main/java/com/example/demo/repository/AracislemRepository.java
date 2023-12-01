package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Aracislem;

@Repository
public interface AracislemRepository extends JpaRepository<Aracislem,Long > {

	 @Query(value = "SELECT * FROM aracislem WHERE plaka = ?1 Order by id desc limit 1", nativeQuery = true)
	  Aracislem findLatestOneByPlaka(String plaka);

	 
	 @Query(value = "SELECT * FROM aracislem WHERE aktif = 1 Order by sms_sent DESC,id ASC ", nativeQuery = true)
	  List<Aracislem> findAllAktif();

	
}
