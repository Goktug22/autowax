package com.example.demo.controller;

import com.example.demo.model.Harcama;
import com.example.demo.repository.HarcamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class HarcamaController {

	@Autowired
	private HarcamaRepository harcamaRepository;

	// Create a new harcama
	@PostMapping("/harcama")
	public Harcama createHarcama(@RequestBody Harcama harcama) {
		return harcamaRepository.save(harcama);
	}

	// Get all harcamalar
	@GetMapping("/harcama")
	public List<Harcama> getAllHarcama() {
		return harcamaRepository.findAll();
	}

	@GetMapping("/harcama/byDateRange")
	public List<Harcama> getHarcamaByDateRange(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		startCal.set(Calendar.MILLISECOND, 0);
		startDate = startCal.getTime();

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		endCal.set(Calendar.HOUR_OF_DAY, 23);
		endCal.set(Calendar.MINUTE, 59);
		endCal.set(Calendar.SECOND, 59);
		endCal.set(Calendar.MILLISECOND, 999);
		endDate = endCal.getTime();
		return harcamaRepository.findAllByTarihBetween(startDate, endDate);
	}

	// Get a single harcama by ID
	@GetMapping("/harcama/{id}")
	public ResponseEntity<Harcama> getHarcamaById(@PathVariable(value = "id") Long harcamaId) {
		Optional<Harcama> harcama = harcamaRepository.findById(harcamaId);

		if(harcama.isPresent()) {
			return ResponseEntity.ok().body(harcama.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update a harcama
	@PutMapping("/harcama/{id}")
	public ResponseEntity<Harcama> updateHarcama(@PathVariable(value = "id") Long harcamaId,
												 @RequestBody Harcama harcamaDetails) {
		Optional<Harcama> harcama = harcamaRepository.findById(harcamaId);

		if(harcama.isPresent()) {
			Harcama updatedHarcama = harcama.get();
			updatedHarcama.setDescription(harcamaDetails.getDescription());
			updatedHarcama.setMiktar(harcamaDetails.getMiktar());
			updatedHarcama.setTarih(harcamaDetails.getTarih());
			final Harcama savedHarcama = harcamaRepository.save(updatedHarcama);
			return ResponseEntity.ok(savedHarcama);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete a harcama
	@DeleteMapping("/harcama/{id}")
	public ResponseEntity<Void> deleteHarcama(@PathVariable(value = "id") Long harcamaId) {
		Optional<Harcama> harcama = harcamaRepository.findById(harcamaId);

		if(harcama.isPresent()) {
			harcamaRepository.delete(harcama.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
