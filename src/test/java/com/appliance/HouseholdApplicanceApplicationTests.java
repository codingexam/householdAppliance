package com.appliance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.appliance.entity.Appliance;
import com.appliance.repository.ApplianceRepository;
import com.appliance.service.ApplianceService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HouseholdApplicanceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ApplianceService service;
	
	@MockBean
	private ApplianceRepository repository;
	
	
	  @Test 
	  public void getAllAppliancesTest() {
	  when(repository.findAll()).thenReturn(Stream .of(new Appliance(1111, "LG","XYZ", "Active", LocalDate.now()),
			  new Appliance(1111, "BRAND", "MODEL","Inactive", LocalDate.now()))
			  .collect(Collectors.toList()));
	  assertEquals(2, service.getAllAppliances().size()); 
	  }
	 
	
	//@Test
	public void getSingleAppliance() 
	{ 
		Integer serialNumber = 1111; Appliance appliance
	  = new Appliance(1111, "LG", "XYZ", "Active", LocalDate.now());
	  when(repository.getById(serialNumber)).thenReturn(appliance);
	  assertEquals(appliance, service.getSingleAppliance(serialNumber)); 
	  
	  }
	 
	
	
	  @Test 
	  public void addAppliance() 
	  { 
	  Appliance appliance = new Appliance(2222,"LG", "XYZ", "USING", LocalDate.now());
	  when(repository.save(appliance)).thenReturn(appliance);
	  assertEquals(appliance, service.addAppliance(appliance)); 
	  }
	 
	
	
		/*
		 * @Test public void updateAppliance() { Appliance updatedAppliance = new
		 * Appliance(3333, "LG", "XYZ", "USING", LocalDate.now());
		 * when(repository.save(updatedAppliance)).thenReturn(updatedAppliance);
		 * assertEquals(updatedAppliance, service.updateAppliance(updatedAppliance));
		 * verify(repository, times(1)).save(updatedAppliance); }
		 */
	 

	
	  @Test public void deleteAppliance() { 
	  Appliance appliance = new Appliance(1111, "LG", "XYZ", "USING", LocalDate.now());
	  service.deleteAppliance(appliance.getSerialNumber()); 
	  verify(repository,times(1)).deleteById(appliance.getSerialNumber()); }
	 
	
	@Test
	public void deleteAllAppliances() {
		service.deleteAllAppliances();
		verify(repository, times(1)).deleteAll();
	}
}
