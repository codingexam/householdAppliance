package com.appliance.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appliance.entity.Appliance;
import com.appliance.repository.ApplianceRepository;

@Service
public class ApplianceServiceImpl implements ApplianceService{
	@Autowired
	private ApplianceRepository repository;
	
	@Override
	public Appliance getSingleAppliance(long serialNum) {
		return repository.getById(serialNum);
	}

	@Override
	public List<Appliance> getAllAppliances(long userId) {
		List<Appliance> appliances = repository.findByUserId(userId);
		return appliances;
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {
		if(appliance.getBrand()==null) {
			throw new RuntimeException("");
		}
		return repository.save(appliance);
	}

	@Override
	public Appliance updateAppliance(Appliance appliance) {
		return repository.save(appliance);
	}
	
	@Override
	public void deleteAppliance(long serialNum) {
		repository.deleteById(serialNum);
	}

	@Override
	public void deleteAllAppliances() {
		repository.deleteAll();
	}
	
}
