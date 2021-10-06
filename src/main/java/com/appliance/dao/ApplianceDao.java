package com.appliance.dao;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.appliance.entity.Appliance;

public interface ApplianceDao {
	public List<Appliance> findAllappliances();
	public Appliance findApplianceBySerialNum(long serialNum);
	public Appliance addAppliance(Appliance appliance);
	public Appliance updateAppliance(Appliance appliance);
	public HttpStatus removeAppliance(long serialNum);
	public void removeAllAppliances();
}
