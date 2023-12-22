package com.example.demo.model;

import com.example.demo.model.serializer.PersonelSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.Date;

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

	@Column( name = "bahsis")
	private Integer bahsis;


	@Column( name = "sms_sent")
	private Boolean smsSent;
	
	@Column( name = "odeme_yontemi")
	private Integer odemeYontemi;
	
	@Column( name = "giris_tarih")
	private Date girisTarih;

	@Column( name = "cikis_tarih")
	private Date cikisTarih;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personel_id")
	@JsonSerialize(using = PersonelSerializer.class)
	private Personel personel;




	public Aracislem() {
		
	}
	
	public Aracislem(String name, String plaka, String numara, String email, boolean aktif, long islemler, String renk, String marka,int fiyat, Date girisTarih , Date cikisTarih) {
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
		this.girisTarih = girisTarih;
		this.cikisTarih=cikisTarih;
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

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

	public Integer getBahsis() {
		return bahsis;
	}

	public void setBahsis(Integer bahsis) {
		this.bahsis = bahsis;
	}
}
