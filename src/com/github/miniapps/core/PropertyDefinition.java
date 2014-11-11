package com.github.miniapps.core;

import java.util.Set;

public abstract class PropertyDefinition {

	protected int id;
	protected Status status;
	protected int index;
	protected boolean required;
	protected String name;
	protected String label;
	protected PropertyType propertyType;
	protected PropertySetDefinition propertySetDefinition;
	protected Set<PropertyOption> propertyOptions;

	public PropertyDefinition() {
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

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public PropertySetDefinition getPropertySetDefinition() {
		return propertySetDefinition;
	}

	public void setPropertySetDefinition(PropertySetDefinition propertySetDefinition) {
		this.propertySetDefinition = propertySetDefinition;
	}

	public Set<PropertyOption> getPropertyOptions() {
		return propertyOptions;
	}

	public void setPropertyOptions(Set<PropertyOption> propertyOptions) {
		this.propertyOptions = propertyOptions;
	}
}
