package com.github.miniapps.core;

public abstract class Property {

	protected int id;
	protected String value;
	protected PropertyDefinition propertyDefinition;
	protected PropertySet propertySet;

	public Property() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isValid() {
		// TODO
		return false;
	}

	public boolean isUnique() {
		// TODO
		return false;
	}
	
	public void reset(){
		// TODO
	}

	public PropertyDefinition getPropertyDefinition() {
		return propertyDefinition;
	}

	public void setPropertyDefinition(PropertyDefinition propertyDefinition) {
		this.propertyDefinition = propertyDefinition;
	}

	public PropertySet getPropertySet() {
		return propertySet;
	}

	public void setPropertySet(PropertySet propertySet) {
		this.propertySet = propertySet;
	}

}
