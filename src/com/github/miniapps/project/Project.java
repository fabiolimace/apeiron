package com.github.miniapps.project;

import java.util.Set;

import com.github.miniapps.core.Status;
import com.github.miniapps.core.Team;
import com.github.miniapps.core.User;

public class Project {

	private int id;
	private Status status;
	private String name;
	private String abbreviation;
	private String description;
	private User owner;
	private Set<Team> teams;
	private Set<Task> tasks;
	
	public Project() {
	}

}
