package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Inventory;
import com.example.demo.model.Islem;
import com.example.demo.model.LastikOtel;
import com.example.demo.repository.LastikOtelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IslemRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/")
public class LastikOtelController {
    @Autowired
    private LastikOtelRepository lastikOtelRepository;

    //get all

    @GetMapping("/lastikotel")
    public List<LastikOtel> getAll(){
        return lastikOtelRepository.findAll();
    }

    @GetMapping("/lastikotelaktif")
    public List<LastikOtel> getAllAktif(){
        return lastikOtelRepository.findAllAktif();
    }

    @PostMapping("/lastikotel")
    public LastikOtel addLastikOtel(@RequestBody LastikOtel lastikOtel) {
        lastikOtel.setGirisTarih( new Date());
        lastikOtel.setAktif(true);
        return lastikOtelRepository.save( lastikOtel);
    }



    @PatchMapping("/lastikotel/{id}")
    public ResponseEntity<LastikOtel>  archiveLastikOtel ( @PathVariable Long id){
        LastikOtel lo = lastikOtelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Lastik otel does not exists with id:  " + id )  );
       lo.setAktif(false);
       lo.setCikisTarih(new Date());
       return ResponseEntity.ok(lastikOtelRepository.save(lo));

    }


    @DeleteMapping("/lastikotel/{id}")
    public ResponseEntity<LastikOtel>   deleteLastikOtel(@PathVariable Long id){
        LastikOtel lastikOtel = lastikOtelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException ( "Lastik Otel does not exists with id:  " + id )  );
        lastikOtelRepository.delete(lastikOtel);
        return ResponseEntity.ok(lastikOtel);

    }



}
