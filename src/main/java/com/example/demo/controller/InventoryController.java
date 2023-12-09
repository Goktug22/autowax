package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.model.InventoryChangeLog;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;


    @GetMapping("/inventory")
    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }
    @PutMapping("inventory/{id}")
    public void updateInventory(@PathVariable Long id,
                                @RequestParam int amount,
                                @RequestParam String description) {
        inventoryService.updateInventory(id, amount, description);
    }

    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save( inventory);
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }

    // Other CRUD endpoints
}
