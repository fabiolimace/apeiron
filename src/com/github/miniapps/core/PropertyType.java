package com.github.miniapps.core;

public class PropertyType {

	private int id;
	private Status status;
	private String name;
	private String label;
	private String pattern;

	public PropertyType() {
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

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean check(String value) {
		// TODO Compare a value with a pattern
		return false;
	}

}
