package com.github.miniapps.core;

import java.util.Set;

public class ContentType {

	protected int id;
	protected Status status;
	protected String name;
	protected Set<ContentTagSet> contentTagSet;

	public ContentType() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
