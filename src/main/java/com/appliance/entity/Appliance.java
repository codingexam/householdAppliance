

package com.appliance.entity;




import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="HOUSEHOLD")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Appliance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERIALNUMBER")
	private Integer serialNumber;

	@Column(name = "brand")
	@NotNull(message = "brand should not be null")
	private String brand;

	@Column(name = "model")
	@NotNull(message = "model should not be null")
	private String model;

	@Column(name = "status")
	@NotNull(message = "status should be either Active or Inactive")
	private String status;

	@Column(name = "DATEBOUGHT")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "date must be specified")
	private Date dateBought;
	
	@Column(name = "userid")
	private Integer userid;

	public Appliance() {
	}

	public Appliance(Integer serialNumber, @NotNull(message = "brand should not be null") String brand,
			@NotNull(message = "model should not be null") String model,
			@NotNull(message = "status should be either Active or Inactive") String status, Date dateBought) {
		super();
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.dateBought = dateBought;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	@Override
	public String toString() {
		return "Appliance [serialNumber=" + serialNumber + ", brand=" + brand + ", model=" + model + ", status="
				+ status + ", dateBought=" + dateBought + "]";
	}

	
}

