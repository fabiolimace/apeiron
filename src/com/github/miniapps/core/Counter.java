package com.github.miniapps.core;

public abstract class Counter {

	protected int id;
	protected int value;
	protected CounterDefinition counterDefinition;
	protected CounterSet counterSet;
	
	public Counter() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CounterDefinition getCounterDefinition() {
		return counterDefinition;
	}

	public void setCounterDefinition(CounterDefinition counterDefinition) {
		this.counterDefinition = counterDefinition;
	}

	public CounterSet getCounterSet() {
		return counterSet;
	}

	public void setCounterSet(CounterSet counterSet) {
		this.counterSet = counterSet;
	}
	
	public void increment(){
		value++;
	}
	
	public void decrement(){
		value--;
	}
	
	public void reset() {
		value = 0;
	}

}
