package com.appliance.service;

import java.util.List;
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
	public List<Appliance> getAllAppliances() {
		List<Appliance> appliances = repository.findAll();
		return appliances;
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {
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
