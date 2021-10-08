package com.appliance.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appliance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long serialNumber;
	private long userId;
	private String brand;
	private String model;
	private String status;
	private LocalDate dateBought;

	Appliance() {}
	
	public Appliance(long serialNumber, long userId, String brand, String model, String status, LocalDate localDate) {
		this.serialNumber = serialNumber;
		this.userId = userId;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.dateBought = localDate;
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

	public LocalDate getDateBought() {
		return dateBought;
	}

	public void setDateBought(LocalDate dateBought) {
		this.dateBought = dateBought;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean equals(Object o) {
		if (this == o)
		      return true;
		    if (!(o instanceof Appliance))
		      return false;
		    Appliance appliance = (Appliance) o;
		    return Objects.equals(this.serialNumber, appliance.serialNumber) && Objects.equals(this.brand, appliance.brand)
		        && Objects.equals(this.model, appliance.model);
	}
	
	public int hashCode() {
		return Objects.hash(this.serialNumber, this.brand, this.model);
	}
	
	public String toString() {
		return "Appliance{" + "serialNumber=" + this.serialNumber + ", brand='" + this.brand + '\'' + ", model='" + this.model + '\'' + '}';
	}
}
