package com.github.miniapps.core;

public class Property {

	protected int id;
	protected String value;

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

}
