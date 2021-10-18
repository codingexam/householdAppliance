package com.appliance.user.service;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appliance.user.entity.User;
import com.appliance.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public User addUser(User user) throws Exception {
		if(userExist(user.getUsername())) {
			throw new Exception("There is an account with that user name: " + user.getUsername());
		}
		user.setUsername(user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save((User) user);
	}

    private boolean userExist(String username) {
        return repository.findByUsername(username) != null;
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
