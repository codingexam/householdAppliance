package com.appliance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appliance.entity.Appliance;
import com.appliance.service.ApplianceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "Home Appliance API having endpoints which are used interact with appliances microservice")
public class ApplianceController {
	private static final Logger logger = LoggerFactory.getLogger(ApplianceController.class);

	@Autowired
	private ApplianceService service;

	// get all appliances
	@GetMapping("/appliances")
	@ApiOperation(value = "Finds all appliances", responseContainer = "List")
	public ResponseEntity<List<Appliance>> getAllAppliances() {
		return new ResponseEntity<List<Appliance>>(service.getAllAppliances(), HttpStatus.OK);
	}

	// get single appliance by serial number
	@GetMapping("/appliance")
	@ApiOperation(value = "Finds single appliance by serial number", response = Appliance.class)
	public ResponseEntity<Appliance> getSingleAppliance(@RequestParam("serialnum") Integer serialNum) {
		return new ResponseEntity<Appliance>(service.getSingleAppliance(serialNum), HttpStatus.OK);
	}

	// add new appliance
	@PostMapping("/appliance")
	@ApiOperation(value = "Adds a new appliance", response = Appliance.class)
	public ResponseEntity<Appliance> addAppliance(@RequestBody @Valid Appliance appliance) {
		logger.info("appliance added status");
		return new ResponseEntity<Appliance>(service.addAppliance(appliance), HttpStatus.OK);
	}

	// update an existing appliance using serial number
	@PutMapping("/appliance")
	@ApiOperation(value = "Updates an appliance using serial number", response = Appliance.class)
	public ResponseEntity<Appliance> updateAppliance(@RequestBody Appliance appliance) {
		logger.info("appliance updated controller");
		String status =  service.updateAppliance(appliance);
		logger.info("Appliance updated status - {}",status);
		return ResponseEntity.status(HttpStatus.OK).body(appliance);
	}

	// delete an appliance using serial number
	@DeleteMapping("/appliance")
	@ApiOperation(value = "Deletes an appliance by serial number")
	public void deleteAppliance(@RequestParam("serialnum") Integer serialNum) {
		logger.info("appliance deleted");
		service.deleteAppliance(serialNum);
	}

	// delete all appliances
	@DeleteMapping("/appliances")
	@ApiOperation(value = "Delete all appliances")
	public void deleteAllAppliances() {
		service.deleteAllAppliances();
	}

	//  all appliances by brand
	@GetMapping("/appliance/{brand}")
	@ApiOperation("Get appliance info by brand")
	Appliance applianceByModel(@PathVariable String brand){
		return service.applianceByBrand(brand);
	}
	
    //  all appliances by model
    @GetMapping("/product/{model}")
	@ApiOperation("Get appliance info by model")
    Appliance productById(@PathVariable String model){
		return service.applianceByModel(model);
		


}
}
