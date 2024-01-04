package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AppointmentController {

	@Autowired
	private AppointmentRepository repository;

	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return repository.findAll();
	}

	@PostMapping("/appointments")
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		return repository.save(appointment);
	}

	@PutMapping("/appointments/{id}/sendSms")
	public ResponseEntity<Appointment> updateSmsSent(@PathVariable(value = "id") Long appointmentId) {
		Appointment appointment = repository.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmentId));

		appointment.setSmsSent(true);
		final Appointment updatedAppointment = repository.save(appointment);
		return ResponseEntity.ok(updatedAppointment);
	}


	// Add other CRUD operations (update, delete) as needed
}
