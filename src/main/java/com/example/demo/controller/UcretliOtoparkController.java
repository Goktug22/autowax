package com.example.demo.controller;

import com.example.demo.model.UcretliOtopark;
import com.example.demo.repository.UcretliOtoparkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UcretliOtoparkController {

	@Autowired
	private UcretliOtoparkRepository repository;

	// CREATE
	@PostMapping("/ucretliotopark")
	public UcretliOtopark createUcretliOtopark(@RequestBody UcretliOtopark ucretliOtopark) {
		return repository.save(ucretliOtopark);
	}

	// READ
	@GetMapping("/ucretliotopark")
	public List<UcretliOtopark> getAllUcretliOtopark() {
		return repository.findAll();
	}

	@GetMapping("/ucretliotopark/{id}")
	public ResponseEntity<UcretliOtopark> getUcretliOtoparkById(@PathVariable(value = "id") Long id) {
		Optional<UcretliOtopark> ucretliOtopark = repository.findById(id);
		return ucretliOtopark.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// UPDATE
	@PutMapping("/ucretliotopark/{id}")
	public ResponseEntity<UcretliOtopark> updateUcretliOtopark(@PathVariable(value = "id") Long id, @RequestBody UcretliOtopark ucretliOtoparkDetails) {
		Optional<UcretliOtopark> ucretliOtopark = repository.findById(id);

		if(ucretliOtopark.isPresent()) {
			UcretliOtopark updatedUcretliOtopark = ucretliOtopark.get();
			updatedUcretliOtopark.setDescription(ucretliOtoparkDetails.getDescription());
			updatedUcretliOtopark.setPlaka(ucretliOtoparkDetails.getPlaka());
			updatedUcretliOtopark.setFiyat(ucretliOtoparkDetails.getFiyat());
			updatedUcretliOtopark.setAktif(ucretliOtoparkDetails.getAktif());
			updatedUcretliOtopark.setIsim(ucretliOtoparkDetails.getIsim());
			updatedUcretliOtopark.setNumara(ucretliOtoparkDetails.getNumara());
			updatedUcretliOtopark.setGirisTarih(ucretliOtoparkDetails.getGirisTarih());
			updatedUcretliOtopark.setCikisTarih(ucretliOtoparkDetails.getCikisTarih());
			updatedUcretliOtopark.setPaid(ucretliOtoparkDetails.getPaid());
			repository.save(updatedUcretliOtopark);
			return ResponseEntity.ok(updatedUcretliOtopark);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// DELETE
	@DeleteMapping("ucretliotopark/{id}")
	public ResponseEntity<?> deleteUcretliOtopark(@PathVariable(value = "id") Long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
