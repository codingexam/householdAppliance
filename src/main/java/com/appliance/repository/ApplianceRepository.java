package com.appliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appliance.entity.Appliance;


public interface ApplianceRepository extends JpaRepository<Appliance, Integer>{
	public Appliance findApplianceBySerialNumber(Integer serialNumber);
	public Appliance findApplianceByModel(String model);
	public Appliance findApplianceByBrand(String brand);
	

}
