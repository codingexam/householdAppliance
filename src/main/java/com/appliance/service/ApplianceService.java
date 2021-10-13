package com.appliance.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.appliance.entity.Appliance;

public interface ApplianceService{
	public Appliance getSingleAppliance(Integer serialNum);
	public List<Appliance> getAllAppliances();
	public Appliance addAppliance(Appliance appliance);
	public String updateAppliance(Appliance appliance);
	public void deleteAppliance(Integer serialNum);
	public void deleteAllAppliances();
	public List<Appliance> applianceByModel(String model);
	public List<Appliance> applianceByBrand(String brand);
	public List<Appliance> applianceByDate(LocalDate dateBought);
	
	
}
