package com.appliance.service;

import java.util.List;

import com.appliance.entity.Appliance;

public interface ApplianceService{
	public Appliance getSingleAppliance(long serialNum);
	public List<Appliance> getAllAppliances(long userId);
	public Appliance addAppliance(Appliance appliance);
	public Appliance updateAppliance(Appliance appliance);
	public void deleteAppliance(long serialNum);
	public void deleteAllAppliances();
}
