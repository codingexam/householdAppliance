package com.appliance.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appliance.entity.Appliance;
import com.appliance.exception.ApplianceInactiveException;
import com.appliance.repository.ApplianceRepository;




@Service
public class ApplianceServiceImpl implements ApplianceService{
	
	private static final Logger logger = LoggerFactory.getLogger(ApplianceServiceImpl.class);
	
	List<Appliance> appliances = new ArrayList<>();
	
	@Autowired
	private ApplianceRepository repository;
	
	@Override
	public Appliance getSingleAppliance(Integer serialNum) {
		return repository.getById(serialNum);
	}

	@Override
	public List<Appliance> getAllAppliances() {
		List<Appliance> appliances = repository.findAll();
		return appliances;
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {
		
		if(appliance.getStatus().equalsIgnoreCase("Inactive")) {
			throw new ApplianceInactiveException("Appliance is Inactive then we cannot add in the appliance list");
		}
		
		logger.info("adding appliance");
		return repository.save(appliance);
	}

	@Override
	public String updateAppliance(Appliance appliance) {
		logger.info("update appliance service");
		for(Appliance appl: appliances) {
			if (appl.getSerialNumber().equals(appliance.getSerialNumber())) {
				appl.setBrand(appliance.getBrand());
				appl.setModel(appliance.getModel());
			    appl.setDateBought(appliance.getDateBought());
			    return "appliance update successfully";
				
				
			}
		}
		return "appliance update failed";
		
	}
	
	@Override
	public void deleteAppliance(Integer serialNum) {
		repository.deleteById(serialNum);
		logger.info("delete appliance by Id");
	}

	@Override
	public void deleteAllAppliances() {
		repository.deleteAll();
	}

	@Override
	public Appliance applianceByModel(String model) {
		return appliances.stream().filter(appliance-> appliance.getModel() == model).findAny().get();
	}

	@Override
	public Appliance applianceByBrand(String brand) {

		return appliances.stream().filter(appliance-> appliance.getModel() == brand).findAny().get();
	}
	
}
