package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Aracislem;
import com.example.demo.model.Islem;
import com.example.demo.repository.IslemRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/")
public class IslemController {
	@Autowired
	private IslemRepository islemRepository;
	
	//get all
	
	@GetMapping("/islem")
	public List<Islem> getAllIslemler(){
		return islemRepository.findAll();
	}
	
	@PostMapping("/islem")
	public Islem createIslem( @RequestBody Islem islem) {
		for ( int x = 0; x < 62;  x++) {
			Islem i = islemRepository.findById( (long)  Math.pow(2, x)  ).orElse(null);
			if ( i == null ) {
				//insert here
				islem.setId((long) Math.pow(2, x));
				return islemRepository.save(islem);
			}
		}
		return islemRepository.save(islem);
	}
	
	@DeleteMapping("/islem/{id}")
	public ResponseEntity<Islem>   deleteIslem( @PathVariable Long id){
		Islem islem = islemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Islem does not exists with id:  " + id )  );
		islemRepository.delete(islem);
		return ResponseEntity.ok(islem);
			
	}
	
	@PutMapping("/islem/{id}")
	public ResponseEntity<Islem>  updateIslem ( @PathVariable Long id, @RequestBody Islem islem){
		Islem i = islemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Islem does not exists with id:  " + id )  );
		i.setFiyat(islem.getFiyat());
		i.setName(islem.getName());
		return ResponseEntity.ok(islemRepository.save(i));
		
	}
	


}
