package com.github.miniapps.core;

public class ContentType {

	protected int id;
	protected Status status;
	protected String name;
	protected TagSet tagSet;
	protected PropertyList propertyList;

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

	public TagSet getTagSet() {
		return tagSet;
	}

	public void setTagSet(TagSet tagSet) {
		this.tagSet = tagSet;
	}

	public PropertyList getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(PropertyList propertyList) {
		this.propertyList = propertyList;
	}

}
