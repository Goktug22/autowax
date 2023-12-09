package com.example.demo.repository;

import com.example.demo.model.InventoryChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryChangeLogRepository extends JpaRepository<InventoryChangeLog,Long > {
	// OR, if you want to leverage the relationship directly:
	List<InventoryChangeLog> findByInventoryIdOrderByChangeDateDesc(Long inventoryId);
}
