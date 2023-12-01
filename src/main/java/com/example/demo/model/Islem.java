package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "islem")
public class Islem {
	
	@Id
	private Long id;
	
	@Column( name = "name")
	private String name;
	@Column( name = "fiyat")
	private Long fiyat;
	

	public Islem() {
		
	}
	
	public Islem(String name, Long fiyat) {
		super();
		this.name = name;
		this.fiyat = fiyat;
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

	public Long getFiyat() {
		return fiyat;
	}

	public void setFiyat(Long fiyat) {
		this.fiyat = fiyat;
	}

	

	
	
	
	
	
	
}
