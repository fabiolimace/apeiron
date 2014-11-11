package com.github.miniapps.core;

import java.util.Set;

public abstract class TagSet {

	protected int id;
	protected Status status;
	protected String name;
	protected String label;
	protected Set<Tag> tags;

	public TagSet() {
	}

	protected Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
