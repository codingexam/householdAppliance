package com.appliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appliance.entity.Appliance;


public interface ApplianceRepository extends JpaRepository<Appliance, Long>{
	public List<Appliance> findByUserId(long userId);
}
