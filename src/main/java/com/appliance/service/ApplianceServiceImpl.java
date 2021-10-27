package com.appliance.service;


import java.util.Date;
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
		Appliance appl = null;

		// appl =
		// repository.findAll().stream().filter(app->app.getSerialNumber()==serialNumber).findAny().orElse(null);
		try {
			// appl = repository.getById(serialNumber);
			appl = repository.findAll().stream().filter(app -> app.getSerialNumber() == serialNumber).findAny()
					.orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return appl;

	}

	@Override
	public List<Appliance> getAllAppliances(long userId) {
		List<Appliance> appliances = repository.findByUserId(userId);
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

	/*
	 * @Override public String updateAppliance(Appliance appliance) {
	 * logger.info("update appliance service"); for (Appliance appl :
	 * repository.findAll()) { if
	 * (appl.getSerialNumber().equals(appliance.getSerialNumber())) {
	 * appl.setBrand(appliance.getBrand()); appl.setModel(appliance.getModel());
	 * appl.setDateBought(appliance.getDateBought()); repository.save(appliance);
	 * return "appliance update successfully";
	 * 
	 * } } return "appliance update failed";
	 * 
	 * }
	 */
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

		return repository.findAll().stream().filter(appliance -> appliance.getModel().equalsIgnoreCase(model))
				.collect(Collectors.toList());

	}

	@Override
	public List<Appliance> applianceByBrand(String brand) {
		// return repository.findApplianceByBrand(brand);

		return repository.findAll().stream().filter(appliance -> appliance.getBrand().equalsIgnoreCase(brand))
				.collect(Collectors.toList());
	}

	@Override
	public List<Appliance> applianceByStatus(String status) {
		return repository.findAll().stream().filter(appliance -> appliance.getStatus().equalsIgnoreCase(status))
				.collect(Collectors.toList());

	}

	@Override
	public List<Appliance> applianceByDate(Date dateBought) {

		// return repository.findByDate(dateBought);
		return repository.findAll().stream().filter(appliance -> appliance.getDateBought().equals(dateBought))
				.collect(Collectors.toList());

	}

	@Override
	public void updateAppliance(Appliance appliance, Integer serialNumber) {

		repository.findAll().stream().map(appl -> {
			if (appl.getSerialNumber().equals(serialNumber)) {
				appl.setBrand(appliance.getBrand());
				appl.setModel(appliance.getModel());
				appl.setDateBought(appliance.getDateBought());
			}
			return appl;
		}).collect(Collectors.toList());
		repository.save(appliance);
	}

}


