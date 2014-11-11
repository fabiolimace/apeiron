package com.github.miniapps.core;

import java.util.Set;

public abstract class CounterSet {

	protected int id;
	protected CounterSetDefinition counterSetDefinition;
	protected Set<Counter> counters;

	public CounterSet() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CounterSetDefinition getCounterSetDefinition() {
		return counterSetDefinition;
	}

	public void setCounterSetDefinition(
			CounterSetDefinition counterSetDefinition) {
		this.counterSetDefinition = counterSetDefinition;
	}

	public Set<Counter> getCounters() {
		return counters;
	}

	public void setCounters(Set<Counter> counters) {
		this.counters = counters;
	}

	public int getSum() {
		// TODO
		return 0;
	}

	public int getWeightedSum() {
		// TODO
		return 0;
	}
	
	public double getAverage() {
		// TODO
		return 0.0;
	}

	public double getWeightedAverage() {
		// TODO
		return 0.0;
	}
	
	public void resetAll(){
		// TODO
	}
}
