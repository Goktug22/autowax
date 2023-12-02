package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Aracislem;
import com.example.demo.repository.AracislemRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/")
public class AracislemController {
	@Autowired
	private AracislemRepository aracislemRepository;
	
	//get all
	
	@GetMapping("/aracislem")
	public List<Aracislem> getAllAracIslemler(){

		return aracislemRepository.findAll();
		
	}
	
	@GetMapping("/aracislemaktif")
	public List<Aracislem> getAllAktifAracIslemler(){

		return  aracislemRepository.findAllAktif();
		
	}
	
	@PostMapping("/aracislem")
	public Aracislem createAracislem( @RequestBody Aracislem aracislem) {
		return aracislemRepository.save(aracislem);
	}
	
	//get aracislem by 
	@GetMapping("/aracislem/{plaka}")
	public ResponseEntity<Aracislem>   getAracislemByPlaka ( @PathVariable String plaka){
		Aracislem aracislem = aracislemRepository.findLatestOneByPlaka(plaka);
		return ResponseEntity.ok(aracislem);
		
	}
	
	//get aracislem by id
	@GetMapping("/aracislembyid/{id}")
	public ResponseEntity<Aracislem>   getAracislemById ( @PathVariable Long id){
		Aracislem aracislem = aracislemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Aracislem does not exists with id:  " + id )  );
		return ResponseEntity.ok(aracislem);
			
		}
	
	//delete aracislem by id
	@DeleteMapping("/aracislem/{id}")
	public ResponseEntity<Aracislem>   deleteAracislemById ( @PathVariable Long id){
		Aracislem aracislem = aracislemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Aracislem does not exists with id:  " + id )  );
		aracislemRepository.delete(aracislem);
		return ResponseEntity.ok(aracislem);
			
		}
	
	
	@PatchMapping("/archivearacislembyid/{id}")
	public ResponseEntity<Aracislem> archiveAracislemById (@PathVariable long id ,@RequestBody Aracislem aracislem  ){
		
		Aracislem ai = aracislemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Aracislem does not exists with id:  " + id )  );
		ai.setAktif(false);
		ai.setOdemeYontemi(aracislem.getOdemeYontemi());
		ai.setAlinanOdeme(aracislem.getAlinanOdeme());
		ai.setCikisTarih(aracislem.getCikisTarih());
		aracislemRepository.save(ai);
		return ResponseEntity.ok(ai);
		
	}
	
	@PatchMapping("/sendsmsaracislembyid/{id}")
	public ResponseEntity<Aracislem> SendSMSAracislemById (@PathVariable long id   ){
		
		Aracislem ai = aracislemRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Aracislem does not exists with id:  " + id )  );
		ai.setSmsSent(true);
		aracislemRepository.save(ai);
		return ResponseEntity.ok(ai);
		
	}
	
	

}
