package com.github.miniapps.core;

import java.util.Set;

public abstract class CounterSetDefinition {

	protected int id;
	protected Status status;
	protected String name;
	protected String label;
	protected Set<CounterDefinition> counterDefinitions;
	
	public CounterSetDefinition() {
		// TODO Auto-generated constructor stub
	}

}
