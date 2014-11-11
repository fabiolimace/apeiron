package com.github.miniapps.core;

public abstract class CounterDefinition {

	protected int id;
	protected Status status;
	protected int weight;
	protected String name;
	protected String label;
	protected CounterSetDefinition counterSetDefinition;
	
	public CounterDefinition() {
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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

	public CounterSetDefinition getCounterSetDefinition() {
		return counterSetDefinition;
	}

	public void setCounterSetDefinition(CounterSetDefinition counterSetDefinition) {
		this.counterSetDefinition = counterSetDefinition;
	}

}
