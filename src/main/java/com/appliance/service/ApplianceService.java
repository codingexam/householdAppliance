package com.appliance.service;


import java.util.Date;
import java.util.List;

import com.appliance.entity.Appliance;

public interface ApplianceService{
	public Appliance getSingleAppliance(Integer serialNumber);
	public List<Appliance> getAllAppliances();
	public Appliance addAppliance(Appliance appliance);
	public String updateAppliance(Appliance appliance);
	public void deleteAppliance(Integer serialNum);
	public void deleteAllAppliances();
	public List<Appliance> applianceByModel(String model);
	public List<Appliance> applianceByBrand(String brand);
	public List<Appliance> applianceByStatus(String status);
	public List<Appliance> applianceByDate(Date dateBought);
	
	
	
	
	
	
}
