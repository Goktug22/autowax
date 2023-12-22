package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personel")
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column( name = "name")
	private String name;

	@OneToMany(mappedBy = "personel", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("personel")
	private List<Aracislem> aracislemler;

	public Personel() {

	}

	public Personel(String name) {
		super();
		this.name = name;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Aracislem> getAracislemler() {
		return aracislemler;
	}

	public void setAracislemler(List<Aracislem> aracislemler) {
		this.aracislemler = aracislemler;
	}


	

	
	
	
	
	
	
}
