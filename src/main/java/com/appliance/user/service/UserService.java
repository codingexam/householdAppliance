package com.appliance.user.service;

import java.util.List;
import java.util.Optional;

import com.appliance.user.entity.User;

public interface UserService {
	public Optional<User> getSingleUser(long userId);
	public User getByUsername(String username);
	public List<User> getAllUsers();
	public User addUser(User user);
	public User updateUser(User user);
}
