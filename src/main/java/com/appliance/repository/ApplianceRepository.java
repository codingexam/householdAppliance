package com.appliance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.appliance.entity.Appliance;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {
	public Appliance findApplianceBySerialNumber(Integer serialNumber);

	public List<Appliance> findApplianceByModel(String model);

	public List<Appliance> findApplianceByBrand(String brand);
	//public List<Appliance> findApplianceByDate(LocalDate dateBought);

}
