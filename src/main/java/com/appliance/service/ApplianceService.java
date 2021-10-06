package com.appliance.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.appliance.entity.Appliance;

public interface ApplianceService {
	public List<Appliance> getAllappliances();
	public Appliance getApplianceBySerialNum(long serialNum);
	public Appliance addAppliance(Appliance appliance);
	public Appliance updateAppliance(Appliance appliance);
	public HttpStatus deleteAppliance(long serialNum);
	public void deleteAllAppliances();
}
