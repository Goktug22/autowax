package com.example.demo.service;

import com.example.demo.model.Inventory;
import com.example.demo.model.InventoryChangeLog;
import com.example.demo.repository.InventoryChangeLogRepository;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryChangeLogRepository inventoryChangeLogRepository;

    @Transactional
    public void updateInventory(Long inventoryId, int newAmount, String changeDescription) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        // Update inventory
        InventoryChangeLog log = new InventoryChangeLog();
        log.setPreviousAmount(inventory.getAmount());
        log.setCurrentAmount(newAmount);
        inventory.setAmount(newAmount);
        inventoryRepository.save(inventory);

        // Log the change
        log.setInventory(inventory);
        log.setChangeDescription(changeDescription);
        inventoryChangeLogRepository.save(log);
    }
}
