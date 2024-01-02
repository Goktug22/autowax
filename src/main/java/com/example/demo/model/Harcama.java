package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "harcama")
public class Harcama {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	@Column( name = "description")
	private String description;
	@Column( name = "miktar")
	private Integer miktar;

	@Column( name = "tarih")
	private Date tarih;

	public Harcama() {

	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMiktar() {
		return miktar;
	}

	public void setMiktar(Integer miktar) {
		this.miktar = miktar;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
}
