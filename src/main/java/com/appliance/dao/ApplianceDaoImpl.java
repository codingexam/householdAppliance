package com.appliance.dao;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.appliance.entity.Appliance;

@Component
public class ApplianceDaoImpl implements ApplianceDao{

	@Override
	public List<Appliance> findAllappliances() {
		return null;
	}

	@Override
	public Appliance findApplianceBySerialNum(long serialNum) {
		return null;
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {
		return null;
	}

	@Override
	public Appliance updateAppliance(Appliance appliance) {
		return null;
	}

	@Override
	public HttpStatus removeAppliance(long serialNum) {
		return null;
	}

	@Override
	public void removeAllAppliances() {		
	}
	
	
}
