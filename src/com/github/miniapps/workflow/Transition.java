package com.github.miniapps.workflow;

import com.github.miniapps.core.Status;

public class Transition {

	private int id;
	private Status status;
	private boolean hidden;
	private String name;
	private ActivityDefinition from;
	private ActivityDefinition to;

	public Transition() {
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

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActivityDefinition getFrom() {
		return from;
	}

	public void setFrom(ActivityDefinition from) {
		this.from = from;
	}

	public ActivityDefinition getTo() {
		return to;
	}

	public void setTo(ActivityDefinition to) {
		this.to = to;
	}

}
