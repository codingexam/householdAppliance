package com.appliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appliance.entity.Appliance;


public interface ApplianceRepository extends JpaRepository<Appliance, Long>{
	public Appliance findApplianceBySerialNumber(long serialNumber);
}
