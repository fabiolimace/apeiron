package com.github.miniapps.core;

import java.util.Date;

public class User {

	private int id;
	private Date creation;
	private Status status;
	private UserType userType;
	private String name;
	private String email;
	private String website;
	private String location;
	private String login;
	private String password;
	private String description;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public Date getCreation() {
		return this.creation;
	}

	public Status getStatus() {
		return this.status;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getWebsite() {
		return this.website;
	}

	public String getLocation() {
		return this.location;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
