package com.appliance.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplianceServiceTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private ApplianceService service;

	@MockBean
	private ApplianceRepository repository;

	@Test
	public void getAllAppliancesTest() {
		when(repository.findAll()).thenReturn(Stream.of(
				new Appliance(1111, "LG", "XYZ", "Active", new java.util.Date(System.currentTimeMillis()),101),
				new Appliance(1111, "BRAND", "MODEL", "Inactive", new java.util.Date(System.currentTimeMillis()),101))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllAppliances(101).size());
	}

	@Test
	public void getSingleApplianceTest() {
		Integer serialNumber = 1111;
		Appliance appliance = new Appliance(1111, "LG", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		when(repository.getById(serialNumber)).thenReturn(appliance);
		assertEquals(appliance, service.getSingleAppliance(serialNumber));
		verify(repository, times(1)).getById(serialNumber);

	}

	@Test
	public void addApplianceTest() {
		Appliance appliance = new Appliance(2222, "LG", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		when(repository.save(appliance)).thenReturn(appliance);
		assertEquals(appliance, service.addAppliance(appliance));
	    verify(repository, times(1)).save(appliance);
		
	}

	@Test
	public void updateApplianceTest() {
		Appliance updatedAppliance = new Appliance(3333, "LG", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
        when(repository.getById(updatedAppliance.getSerialNumber())).thenReturn(updatedAppliance);
        
		//when(repository.save(updatedAppliance)).thenReturn(updatedAppliance);
		//assertThat(service.updateAppliance(updatedAppliance)).isNotNull();
	  //   assertEquals(updatedAppliance, service.updateAppliance(updatedAppliance));
		// verify(repository).save(updatedAppliance);
	}

	@Test
	public void deleteApplianceTest() {
		Appliance appliance = new Appliance(1111, "LG", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		service.deleteAppliance(appliance.getSerialNumber());
		verify(repository, times(1)).deleteById(appliance.getSerialNumber());
	}

	@Test
	public void deleteAllAppliancesTest() {
		service.deleteAllAppliances();
		verify(repository, times(1)).deleteAll();
	}
	
	@Test
	public void applianceByBrandTest() {
		String brand = "PHILPS";
		Appliance appliance = new Appliance(1111, "PHILPS", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		
	}
	@Test
	public void applianceByModelTest() {
		String model = "XYZ";
		Appliance appliance = new Appliance(1111, "PHILPS", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		
	}
	@Test
	public void applianceByStatusTest() {
		String status = "Active";
		Appliance appliance = new Appliance(1111, "PHILPS", "XYZ", "Active",
				new java.util.Date(System.currentTimeMillis()),101);
		
	}
	@Test
	public void applianceByDateTest() {
		
		
	}
	
	}

