package com.appliance.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.appliance.entity.Appliance;
import com.appliance.repository.ApplianceRepository;

public class ApplianceServiceTests {
	
	@Autowired
	private ApplianceService service;
	
	@MockBean
	private ApplianceRepository repository;
	
	@Test
	public void getAllAppliancesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Appliance(1111, "LG", "XYZ", "USING", LocalDate.now(), 002),
						new Appliance(1111, "BRAND", "MODEL", "NOT IN USE", LocalDate.now(), 002)
						).collect(Collectors.toList()));
		assertEquals(2, service.getAllAppliances(002).size());
	}
	
	@Test
	public void getSingleAppliance() {
		long serialNum = 1111;
		Appliance appliance = new Appliance(1111, "LG", "XYZ", "USING", LocalDate.now(), 002);
		when(repository.getById(serialNum)).thenReturn(appliance);
		assertEquals(appliance, service.getSingleAppliance(serialNum));
	}
	
	@Test
	public void addAppliance() {
		Appliance appliance = new Appliance(2222, "LG", "XYZ", "USING", LocalDate.now(), 002);
		when(repository.save(appliance)).thenReturn(appliance);
		assertEquals(appliance, service.addAppliance(appliance));
	}
	
	@Test
	public void updateAppliance() {
		Appliance updatedAppliance = new Appliance(3333, "LG", "XYZ", "USING", LocalDate.now(), 002);
		when(repository.save(updatedAppliance)).thenReturn(updatedAppliance);
		assertEquals(updatedAppliance, service.updateAppliance(updatedAppliance));
		verify(repository, times(1)).save(updatedAppliance);
	}

	/*
	 * @Test public void deleteAppliance() { Appliance appliance = new
	 * Appliance(1111, "LG", "XYZ", "USING", LocalDate.now());
	 * service.deleteAppliance(appliance.getSerialNumber()); verify(repository,
	 * times(1)).deleteById(appliance.getSerialNumber()); }
	 */
	
	@Test
	public void deleteAllAppliances() {
		service.deleteAllAppliances();
		verify(repository, times(1)).deleteAll();
	}
}
