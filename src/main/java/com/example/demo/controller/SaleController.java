package com.example.demo.controller;

import com.example.demo.model.Sale;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class SaleController {

	@Autowired
	private SaleRepository repository;

	// CREATE
	@PostMapping("/sales")
	public Sale createSale(@RequestBody Sale sale) {
		return repository.save(sale);
	}

	// READ
	@GetMapping("/sales")
	public List<Sale> getAllSales() {
		return repository.findAll();
	}

	@GetMapping("/sales/{id}")
	public ResponseEntity<Sale> getSaleById(@PathVariable(value = "id") Long id) {
		Optional<Sale> sale = repository.findById(id);
		return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// UPDATE
	@PutMapping("/sales/{id}")
	public ResponseEntity<Sale> updateSale(@PathVariable(value = "id") Long id, @RequestBody Sale saleDetails) {
		Optional<Sale> sale = repository.findById(id);

		if(sale.isPresent()) {
			Sale updatedSale = sale.get();
			updatedSale.setDescription(saleDetails.getDescription());
			updatedSale.setPriceBought(saleDetails.getPriceBought());
			updatedSale.setPriceSold(saleDetails.getPriceSold());
			updatedSale.setPaid(saleDetails.getPaid());
			updatedSale.setName(saleDetails.getName());
			updatedSale.setNumber(saleDetails.getNumber());
			updatedSale.setCreateDate(saleDetails.getCreateDate());
			repository.save(updatedSale);
			return ResponseEntity.ok(updatedSale);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// DELETE
	@DeleteMapping("/sales/{id}")
	public ResponseEntity<?> deleteSale(@PathVariable(value = "id") Long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
