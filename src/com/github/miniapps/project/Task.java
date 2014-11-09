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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Upload> getUploads() {
		return uploads;
	}

	public void setUploads(Set<Upload> uploads) {
		this.uploads = uploads;
	}

}
