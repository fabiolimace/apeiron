package com.github.miniapps.workflow;

import com.github.miniapps.core.Role;
import com.github.miniapps.core.Status;

public class ActivityDefinition {

	private int id;
	private Status status;
	private String name;
	private Role role;
	private WorkflowDefinition workflowDefinition;
	private Transition defaultTransition;

	public ActivityDefinition() {
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

	public WorkflowDefinition getWorkflowDefinition() {
		return workflowDefinition;
	}

	public void setWorkflowDefinition(WorkflowDefinition workflowDefinition) {
		this.workflowDefinition = workflowDefinition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Transition getDefaultTransition() {
		return defaultTransition;
	}

	public void setDefaultTransition(Transition defaultTransition) {
		this.defaultTransition = defaultTransition;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
