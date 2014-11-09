package com.github.miniapps.website;

import com.github.miniapps.core.Status;
import com.github.miniapps.core.Team;

public class Website {

	private int id;
	private Status status;
	private Website parent;
	private String context;
	private String name;
	private Team team;

	public Website() {
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

	public Website getParent() {
		return parent;
	}

	public void setParent(Website parent) {
		this.parent = parent;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
