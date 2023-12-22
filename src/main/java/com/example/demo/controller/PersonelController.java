package com.example.demo.controller;

import com.example.demo.model.Personel;
import com.example.demo.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PersonelController {

	@Autowired
	private PersonelRepository personelRepository;

	// Create a new personel
	@PostMapping("/personel")
	public Personel createPersonel(@RequestBody Personel personel) {
		return personelRepository.save(personel);
	}

	// Get all personnel
	@GetMapping("/personel")
	public List<Personel> getAllPersonel() {
		return personelRepository.findAll();
	}

	// Get a single personel by ID
	@GetMapping("/personel/{id}")
	public ResponseEntity<Personel> getPersonelById(@PathVariable(value = "id") Long personelId) {
		Optional<Personel> personel = personelRepository.findById(personelId);

		if(personel.isPresent()) {
			return ResponseEntity.ok().body(personel.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update a personel
	@PutMapping("/personel/{id}")
	public ResponseEntity<Personel> updatePersonel(@PathVariable(value = "id") Long personelId,
												   @RequestBody Personel personelDetails) {
		Optional<Personel> personel = personelRepository.findById(personelId);

		if(personel.isPresent()) {
			Personel updatedPersonel = personel.get();
			updatedPersonel.setName(personelDetails.getName());
			final Personel savedPersonel = personelRepository.save(updatedPersonel);
			return ResponseEntity.ok(savedPersonel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete a personel
	@DeleteMapping("/personel/{id}")
	public ResponseEntity<Void> deletePersonel(@PathVariable(value = "id") Long personelId) {
		Optional<Personel> personel = personelRepository.findById(personelId);

		if(personel.isPresent()) {
			personelRepository.delete(personel.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
