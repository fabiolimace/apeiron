package com.github.miniapps.website;

import com.github.miniapps.core.CommentType;
import com.github.miniapps.core.ContentType;
import com.github.miniapps.workflow.WorkflowDefinition;

public class PageType extends ContentType {

	private CommentType commentType;
	private WorkflowDefinition workflowDefinition;
	private String template;

	public PageType() {
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public WorkflowDefinition getWorkflowDefinition() {
		return workflowDefinition;
	}

	public void setWorkflowDefinition(WorkflowDefinition workflowDefinition) {
		this.workflowDefinition = workflowDefinition;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
