package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lastik_otel")
public class LastikOtel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column( name = "description")
	private String description;

	@Column( name = "plaka")
	private String plaka;
	@Column( name = "fiyat")
	private Integer fiyat;
	@Column( name = "aktif")
	private Boolean aktif;
	@Column(name = "isim")
	private String isim;
	@Column(name="numara")
	private String numara;
	@Column( name = "giris_tarih")
	private Date girisTarih;

	@Column( name = "cikis_tarih")
	private Date cikisTarih;

	@Column ( name="otel_no")
	private Integer otelNo;








	public LastikOtel() {

	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public Integer getFiyat() {
		return fiyat;
	}

	public void setFiyat(Integer fiyat) {
		this.fiyat = fiyat;
	}

	public Boolean getAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getNumara() {
		return numara;
	}

	public void setNumara(String numara) {
		this.numara = numara;
	}

	public Date getGirisTarih() {
		return girisTarih;
	}

	public void setGirisTarih(Date girisTarih) {
		this.girisTarih = girisTarih;
	}

	public Date getCikisTarih() {
		return cikisTarih;
	}

	public void setCikisTarih(Date cikisTarih) {
		this.cikisTarih = cikisTarih;
	}

	public Integer getOtelNo() {
		return otelNo;
	}

	public void setOtelNo(Integer otelNo) {
		this.otelNo = otelNo;
	}
}
