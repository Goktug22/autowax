package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column( name = "description")
	private String description;

	@Column( name = "price_bought")
	private Integer priceBought;
	@Column( name = "price_sold")
	private Integer priceSold;
	@Column( name = "paid")
	private Boolean paid;
	@Column(name = "name")
	private String name;
	@Column(name="number")
	private String number;
	@Column( name = "create_date")
	private Date createDate;

	public Sale() {

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

	public Integer getPriceBought() {
		return priceBought;
	}

	public void setPriceBought(Integer priceBought) {
		this.priceBought = priceBought;
	}

	public Integer getPriceSold() {
		return priceSold;
	}

	public void setPriceSold(Integer priceSold) {
		this.priceSold = priceSold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
}
