package com.github.miniapps.core;

import java.util.Set;

public abstract class PropertySetDefinition {

	protected int id;
	protected Status status;
	protected String name;
	protected String label;
	protected Set<PropertyDefinition> propertyDefinitions;

	public PropertySetDefinition() {
		// TODO Auto-generated constructor stub
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<PropertyDefinition> getPropertyDefinitions() {
		return propertyDefinitions;
	}

	public void setPropertyDefinitions(
			Set<PropertyDefinition> propertyDefinitions) {
		this.propertyDefinitions = propertyDefinitions;
	}

}
