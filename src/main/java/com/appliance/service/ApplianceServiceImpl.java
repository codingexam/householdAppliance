package com.appliance.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appliance.entity.Appliance;
import com.appliance.exception.ApplianceInactiveException;
import com.appliance.repository.ApplianceRepository;

@Service
public class ApplianceServiceImpl implements ApplianceService {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceServiceImpl.class);

	// List<Appliance> appliances = new ArrayList<>();

	@Autowired
	private ApplianceRepository repository;

	@Override
	public Appliance getSingleAppliance(Integer serialNumber) {
		return repository.getById(serialNumber);
	}

	@Override
	public List<Appliance> getAllAppliances() {
		List<Appliance> appliances = repository.findAll();
		return appliances;
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {

		if (appliance.getStatus().equalsIgnoreCase("Inactive")) {
			throw new ApplianceInactiveException("Appliance is Inactive then we cannot add in the appliance list");
		}

		logger.info("adding appliance");
		return repository.save(appliance);
	}

	@Override
	public String updateAppliance(Appliance appliance) {
		logger.info("update appliance service");
		for (Appliance appl : repository.findAll()) {
			if (appl.getSerialNumber().equals(appliance.getSerialNumber())) {
				appl.setBrand(appliance.getBrand());
				appl.setModel(appliance.getModel());
				appl.setDateBought(appliance.getDateBought());
				repository.save(appliance);
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
	public List<Appliance> applianceByModel(String model) {
		/*
		 * return repository.findAll().stream().filter(appliance ->
		 * appliance.getModel().equalsIgnoreCase(model)) .collect(Collectors.toList());
		 */
		return repository.findApplianceByModel(model);
	}

	@Override
	public List<Appliance> applianceByBrand(String brand) {
		return repository.findApplianceByBrand(brand);

		// return repository.findAll().stream().filter(appliance->
		// appliance.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
	}

	/*
	 * @Override public List<Appliance> applianceByDate(LocalDate dateBought) {
	 * 
	 * return repository.findApplianceByDate(dateBought);
	 * 
	 * return repository.findAll().stream().filter(appliance->
	 * appliance.getDateBought()==dateBought) .collect(Collectors.toList());
	 * 
	 * }
	 */

}
