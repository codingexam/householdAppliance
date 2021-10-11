package com.appliance.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.appliance.entity.Appliance;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "username")
	@NotNull(message = "username should not be null")
	private String username;

	@Column(name = "password")
	@NotNull(message = "password should not be null")
	private String password;

	public User() {}
	
	public User(@NotNull(message = "username should not be null") String username,
			@NotNull(message = "password should not be null") String password, long userId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
	}

	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
	    private List<Appliance> listAppliances = new ArrayList<>();
	 
	public String getUsername() {
		return username;
	}
	
	public long getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
