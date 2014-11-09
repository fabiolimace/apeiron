package com.github.miniapps.project;

import java.util.Set;

import com.github.miniapps.core.Comment;
import com.github.miniapps.core.Content;
import com.github.miniapps.core.User;
import com.github.miniapps.repository.Upload;
import com.github.miniapps.workflow.Workflow;

public class Task extends Content {

	private int id;
	private String title;
	private String taskText;
	private User assignee;
	private Project project;
	private Workflow workflow;
	private Set<Comment> comments;
	private Set<Upload> uploads;

	public Task() {
	}

}
