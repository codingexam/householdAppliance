package com.appliance.controller;


import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	 

	// add new appliance
	@PostMapping("/appliance")
	@ApiOperation(value = "Adds a new appliance", response = Appliance.class)
	public ResponseEntity<Appliance> addAppliance(@RequestBody @Valid Appliance appliance) {
		try {
			logger.info("appliance added status");
			Appliance appl = service.addAppliance(appliance);
			return new ResponseEntity<Appliance>(appl, HttpStatus.CREATED);
		}
		
		catch (NoSuchElementException e) {
			return new ResponseEntity<Appliance>(HttpStatus.NO_CONTENT);
		}
	}

	// update an existing appliance using serial number
	/*
	 * @PutMapping("/appliance")
	 * 
	 * @ApiOperation(value = "Updates an appliance using serial number", response =
	 * Appliance.class) public ResponseEntity<Appliance>
	 * updateAppliance(@RequestBody Appliance appliance) {
	 * logger.info("appliance updated controller"); String status =
	 * service.updateAppliance(appliance);
	 * logger.info("Appliance updated status - {}", status); return
	 * ResponseEntity.status(HttpStatus.OK).body(appliance); }
	 */

	@PutMapping("/appliance/{serialNumber}")
	@ApiOperation(value = "Updates an appliance using serial number", response = Appliance.class)
	public ResponseEntity<Appliance> updateAppliance(@RequestBody Appliance appliance,
			@PathVariable Integer serialNumber) {
		try {
			logger.info("appliance updated controller");
			this.service.updateAppliance(appliance,serialNumber);
			return ResponseEntity.ok().body(appliance);
		} catch (Exception e) {
          e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// delete an appliance using serial number
	@DeleteMapping("/appliance/{serialNum}")
	@ApiOperation(value = "Deletes an appliance by serial number")
	public ResponseEntity<Void> deleteAppliance(@PathVariable Integer serialNum) {
		try{
			logger.info("appliance deleted");
			 service.deleteAppliance(serialNum);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// delete all appliances
	@DeleteMapping("/appliances")
	@ApiOperation(value = "Delete all appliances")
	public void deleteAllAppliances() {
		service.deleteAllAppliances();
	}
	
	@GetMapping("/appliance/{serialNumber}")
	@ApiOperation(value = "Finds single appliance by serial number", response = Appliance.class)
	public ResponseEntity<Appliance> getSingleAppliance(@PathVariable Integer serialNumber) {
		Appliance appl = service.getSingleAppliance(serialNumber);
		
		  if(appl==null)
		  { return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  } 
		  return ResponseEntity.of(Optional.of(appl));
		 
		
		/*
		 * try { logger.info("get appliance by serial Number"); Appliance appl =
		 * service.getSingleAppliance(serialNumber); return new
		 * ResponseEntity<Appliance>(appl, HttpStatus.OK);
		 * 
		 * } catch (NoSuchElementException e) { return new
		 * ResponseEntity<Appliance>(HttpStatus.NOT_FOUND); }
		 */
		 
	}
	

	// all appliances by brand
	@GetMapping("/applianceBrands/{brand}")
	@ApiOperation("Get appliance info by brand")
	ResponseEntity<List<Appliance>> applianceByBrand(@PathVariable String brand) {
		List<Appliance> list =  service.applianceByBrand(brand);
		if(list.size()<=0) {
	  		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	  	}
	  	else {
	  		return ResponseEntity.of(Optional.of(list));
	  	}
	}

	// all appliances by model
	@GetMapping("/applianceModels/{model}")
	@ApiOperation("Get appliance info by model")
	ResponseEntity<List<Appliance>> applianceByModel(@PathVariable String model) {
		List<Appliance> list = service.applianceByModel(model);
		if(list.size()<=0) {
	  		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	  	}
	  	else {
	  		return ResponseEntity.of(Optional.of(list));
	  	}
	}

	
	// all appliances by Date
	//@GetMapping("/applianceDates")
	@GetMapping("/appliancesByDate")
	@ApiOperation("Get appliances info by date")
	ResponseEntity<List<Appliance>> applianceByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateBought) {
		List<Appliance> list =  service.applianceByDate(dateBought);
		if(list.size()<=0) {
	  		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	  	}
	  	else {
	  		return ResponseEntity.of(Optional.of(list));
	  	}
	}

	// all appliances by status
	@GetMapping("appliancesByStatus/{status}")
	@ApiOperation("Get appliance info by status")
	ResponseEntity<List<Appliance>> applianceByStatus(@PathVariable String status) {
		  	List<Appliance> list =  service.applianceByStatus(status);
		  	if(list.size()<=0) {
		  		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  	}
		  	else {
		  		return ResponseEntity.of(Optional.of(list));
		  	}
		  	
	}
    
}
