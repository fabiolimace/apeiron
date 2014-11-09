package com.github.miniapps.workflow;

import java.util.Set;

import com.github.miniapps.core.Status;

public class WorkflowDefinition {

	private int id;
	private Status status;
	private String name;
	private Set<ActivityDefinition> activityDefinitions;
	private ActivityDefinition fristActivitiDefinition;

	public WorkflowDefinition() {
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

	public Set<ActivityDefinition> getActivityDefinitions() {
		return activityDefinitions;
	}

	public void setActivityDefinitions(
			Set<ActivityDefinition> activityDefinitions) {
		this.activityDefinitions = activityDefinitions;
	}

	public ActivityDefinition getFristActivitiDefinition() {
		return fristActivitiDefinition;
	}

	public void setFristActivitiDefinition(
			ActivityDefinition fristActivitiDefinition) {
		this.fristActivitiDefinition = fristActivitiDefinition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
