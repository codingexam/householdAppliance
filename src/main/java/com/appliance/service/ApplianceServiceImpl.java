package com.appliance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appliance.dao.ApplianceDao;
import com.appliance.entity.Appliance;

@Service
public class ApplianceServiceImpl implements ApplianceService, JpaRepository<Appliance, Long>{
	@Autowired
	private ApplianceDao applianceDao;
	
	@Override
	public List<Appliance> getAllappliances() {
		return applianceDao.findAllappliances();
	}

	@Override
	public Appliance getApplianceBySerialNum(long serialNum) {
		return applianceDao.findApplianceBySerialNum(serialNum);
	}

	@Override
	public Appliance addAppliance(Appliance appliance) {
		return applianceDao.addAppliance(appliance);
	}

	@Override
	public Appliance updateAppliance(Appliance appliance) {
		return applianceDao.updateAppliance(appliance);
	}

	@Override
	public HttpStatus deleteAppliance(long serialNum) {
		return applianceDao.removeAppliance(serialNum);
	}

	@Override
	public void deleteAllAppliances() {
		
	}

	@Override
	public Page<Appliance> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Appliance> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Appliance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Appliance> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Appliance> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Appliance> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Appliance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appliance> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appliance> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Appliance> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Appliance> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appliance getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appliance getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Appliance> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
