package com.github.miniapps.repository;

import java.util.Date;

import com.github.miniapps.core.User;

public class Upload {

	private int id;
	private Date cration;
	private Status status;
	private String hash;
	private String mime;
	private int size;
	private User user;
	private String path;
	private String name;
	private String description;

	public enum Status {
		ACTIVE, INACTIVE
	}

	public Upload() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCration() {
		return cration;
	}

	public void setCration(Date cration) {
		this.cration = cration;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
