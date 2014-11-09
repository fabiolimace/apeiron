package com.github.miniapps.core;

import java.util.List;

public class PropertyList {

	protected int id;
	protected Status status;
	protected String name;
	protected List<PropertyDefinition> propertyDefinitions;

	public PropertyList() {
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

	public List<PropertyDefinition> getPropertyDefinitions() {
		return propertyDefinitions;
	}

	public void setPropertyDefinitions(
			List<PropertyDefinition> propertyDefinitions) {
		this.propertyDefinitions = propertyDefinitions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
