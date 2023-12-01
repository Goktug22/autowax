package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aracislem")
public class Aracislem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column( name = "name")
	private String name;
	
	@Column( name = "plaka")
	private String plaka;
	
	@Column( name = "numara")
	private String numara;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "aktif")
	private Boolean aktif;
	
	@Column( name = "marka")
	private String marka;
	
	@Column( name = "renk")
	private String renk;
	
	@Column( name = "islemler")
	private Long islemler;

	@Column( name = "fiyat")
	private Integer fiyat;

	@Column( name = "alinan_odeme")
	private Integer alinanOdeme;

	@Column( name = "sms_sent")
	private Boolean smsSent;
	
	@Column( name = "odeme_yontemi")
	private Integer odemeYontemi;
	
	


	public Aracislem() {
		
	}
	
	public Aracislem(String name, String plaka, String numara, String email, boolean aktif, long islemler, String renk, String marka,int fiyat) {
		super();
		this.name = name;
		this.plaka = plaka;
		this.numara = numara;
		this.email = email;
		this.aktif = aktif;
		this.islemler = islemler;
		this.renk = renk;
		this.marka = marka;
		this.fiyat = fiyat;
	}
	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
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

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getNumara() {
		return numara;
	}

	public void setNumara(String numara) {
		this.numara = numara;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}

	public Long getIslemler() {
		return islemler;
	}

	public void setIslemler(Long islemler) {
		this.islemler = islemler;
	}

	public Integer getFiyat() {
		return fiyat;
	}

	public void setFiyat(Integer fiyat) {
		this.fiyat = fiyat;
	}

	public Integer getAlinanOdeme() {
		return alinanOdeme;
	}

	public void setAlinanOdeme(Integer alinanOdeme) {
		this.alinanOdeme = alinanOdeme;
	}

	public Boolean isSmsSent() {
		return smsSent;
	}

	public void setSmsSent(Boolean smsSent) {
		this.smsSent = smsSent;
	}

	public Integer getOdemeYontemi() {
		return odemeYontemi;
	}

	public void setOdemeYontemi(Integer odemeYontemi) {
		this.odemeYontemi = odemeYontemi;
	}

	public Boolean getAktif() {
		return aktif;
	}

	public Boolean getSmsSent() {
		return smsSent;
	}
	
	

	
	
	
	
	
	
}
