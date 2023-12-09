package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.model.InventoryChangeLog;
import com.example.demo.repository.InventoryChangeLogRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class InventoryChangeLogController {

    @Autowired
    private InventoryChangeLogRepository inventoryChangeLogRepository;


    @GetMapping("/inventorychangelog/{id}")
    public List<InventoryChangeLog> getAll(@PathVariable Long id ){
        return inventoryChangeLogRepository.findByInventoryIdOrderByChangeDateDesc(id);
    }


    // Other CRUD endpoints
}
