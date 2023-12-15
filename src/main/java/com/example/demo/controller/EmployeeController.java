package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
		
	}
	
	@PostMapping("employees")
	public Employee createEmployee( @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee>   getEmployeeById ( @PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Employee does not exists with id:  " + id )  );
		return ResponseEntity.ok(employee);
		
	}

}
