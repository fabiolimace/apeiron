package com.github.miniapps.core;

import java.util.Set;

public abstract class PropertySet {

	protected int id;
	protected PropertySetDefinition propertySetDefinition;
	protected Set<Property> properties;

	public PropertySet() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
	public Property getProperty(String name) {
		// TODO
		return null;
	}
	
	public void setProperty(String name, String value){
		// TODO
	}

	public void resetAll(){
		// TODO
	}
}
