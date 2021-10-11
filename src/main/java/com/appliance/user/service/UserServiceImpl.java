package com.appliance.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appliance.user.entity.User;
import com.appliance.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public Optional<User> getSingleUser(long userId) {
		return repository.findById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public User getByUsername(String username) {
		return repository.findByUsername(username);
	}

}
