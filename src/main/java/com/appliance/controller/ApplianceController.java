package com.appliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appliance.entity.Appliance;
import com.appliance.service.ApplianceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ApplianceController {
	
	@Autowired
	private ApplianceService applianceService;
	
	// get all appliances
	@GetMapping("/appliances")
	@ApiOperation(value = "Finds all Appliances",
	  responseContainer = "List")
	public ResponseEntity<List<Appliance>> getAllAppliances(){
		return new ResponseEntity<List<Appliance>>(applianceService.getAllappliances(), HttpStatus.OK);
	}
		
	// get appliance by serial number
	@GetMapping("/appliance")
	@ApiOperation(value = "Finds an appliance by serial number",
				  response = Appliance.class)
	public ResponseEntity<Appliance> getApplianceBySerialNum(@RequestParam("serialnum") long serialNum){
		return new ResponseEntity<Appliance>(applianceService.getApplianceBySerialNum(serialNum), HttpStatus.OK);
	}
	
	// add new appliance
	@PostMapping("/appliances")
	@ApiOperation(value = "Adds a new appliance",
			      response = Appliance.class)
	public ResponseEntity<Appliance> addAppliance(@Validated @RequestBody Appliance appliance) {
		return new ResponseEntity<Appliance>(applianceService.addAppliance(appliance), HttpStatus.OK);
	}
	
	// update an existing appliance using serial number
	@PutMapping
	@ApiOperation(value = "Updates an appliance using serial number",
				  response = Appliance.class)
	public ResponseEntity<Appliance> updateAppliance(@RequestBody Appliance appliance) {
		return new ResponseEntity<Appliance>(applianceService.updateAppliance(appliance), HttpStatus.OK);
	}
	
	// delete an appliance using serial number
	@DeleteMapping("/remove")
	@ApiOperation(value = "Deletes an appliance by serial number",
				  response = HttpStatus.class)
	public ResponseEntity<HttpStatus> deleteAppliance(@RequestParam("serialnum") long serialNum) {
		return new ResponseEntity<HttpStatus>(applianceService.deleteAppliance(serialNum));
	}
	
	// delete all appliances
	@DeleteMapping("/remove-all")
	@ApiOperation(value = "Delete all appliances")
	public ResponseEntity<HttpStatus> deleteAllAppliances() {
		return null;
	}
}
