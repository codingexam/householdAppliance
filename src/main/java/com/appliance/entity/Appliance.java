package com.appliance.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Appliance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long serialNumber;
	private String brand;
	private String model;
	private String status;
	private Date dateBought;

	Appliance(long serialNumber, String brand, String model, String status, Date dateBought) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.dateBought = dateBought;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateBought() {
		return dateBought;
	}

	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}

}
