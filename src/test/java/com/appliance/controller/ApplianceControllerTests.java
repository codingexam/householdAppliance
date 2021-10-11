package com.appliance.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.appliance.entity.Appliance;
import com.appliance.service.ApplianceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ApplianceController.class)
public class ApplianceControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ApplianceService service;
	
	@InjectMocks
	ApplianceController controller;
	
	@Autowired
    ObjectMapper mapper;
	
	Appliance appliance1 = new Appliance(1111, "Samsung", "TV", "USING", LocalDate.now(), 002);
	Appliance appliance2 = new Appliance(2222, "HP", "PC", "USING", LocalDate.now(), 002);
	Appliance appliance3 = new Appliance(3333,  "Intel", "PCM", "NOT USING", LocalDate.now(), 002);
	List<Appliance> appliances = new ArrayList<Appliance>();

	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	@Test
	public void getAllAppliances_success() throws Exception{
		appliances.add(appliance1);
		appliances.add(appliance2);
		appliances.add(appliance3);
		
		Mockito.when(service.getAllAppliances(002)).thenReturn(appliances);
		
		mockMvc.perform(get("/api/appliances")
			    .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$", hasSize(3)))
			    .andExpect(jsonPath("$[1].brand", is("HP")));
	}
	
	@Test
	public void getSingleAppliance_success() throws Exception{
		
		Mockito.when(service.getSingleAppliance(appliance1.getSerialNumber())).thenReturn(appliance1);
		
		mockMvc.perform(get("/api/appliance?serialnum=1")
			    .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$", notNullValue()))
			    .andExpect(jsonPath("$.brand", is("Samsung")));
	}
	
	
	@Test
	public void addAppliance_success() throws Exception {
	
	    Mockito.when(service.addAppliance(appliance1)).thenReturn(appliance1);
	
	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/appliance")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(appliance1));
	
	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.brand", is("Samsung")));
    }
	
	@Test
	public void updateAppliance_success() throws Exception {
		Appliance updatedAppliance = new Appliance(4444, "Samsung-NEW", "TV", "NOT USING", LocalDate.now(), 002);
	    
		Mockito.when(service.getSingleAppliance(appliance1.getSerialNumber())).thenReturn(appliance1);
		Mockito.when(service.updateAppliance(updatedAppliance)).thenReturn(updatedAppliance);
	
	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/appliance")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(updatedAppliance));
	
	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.brand", is("Samsung-NEW")))
	            .andExpect(jsonPath("$.status", is("NOT USING")));
    }
	
	@Test
	public void deleteApplianceBySerialNum_success() throws Exception {
	    Mockito.when(service.getSingleAppliance(appliance2.getSerialNumber())).thenReturn(appliance2);

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/api/appliance/remove?serialnum=2")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void deleteAllAppliances_success() throws Exception {
	    Mockito.when(service.getAllAppliances(002)).thenReturn(appliances);

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/api/appliance/remove-all")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
}
