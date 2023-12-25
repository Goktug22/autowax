package com.example.demo.repository;

import com.example.demo.model.UcretliOtopark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UcretliOtoparkRepository extends JpaRepository<UcretliOtopark, Long> {
    // Custom query methods can be defined here if needed
}
