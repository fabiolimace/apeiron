package com.github.miniapps.workflow;

import java.util.Date;

import com.github.miniapps.core.Status;

public abstract class Activity {

	protected int id;
	protected Status status;
	protected Date startDate;
	protected Date endDate;
	protected Workflow workflow;
	protected ActivityDefinition activityDefinition;

	public Activity() {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ActivityDefinition getActivityDefinition() {
		return activityDefinition;
	}

	public void setActivityDefinition(ActivityDefinition activityDefinition) {
		this.activityDefinition = activityDefinition;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}
