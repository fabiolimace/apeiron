package com.github.miniapps.website;

import java.util.Set;

import com.github.miniapps.core.Comment;
import com.github.miniapps.core.Content;
import com.github.miniapps.repository.Upload;
import com.github.miniapps.workflow.Workflow;

public class Page extends Content {

	private Website website;
	private int index;
	private String slug;
	private String title;
	private String description;
	private String contentText;
	private Workflow workflow;
	private Set<Comment> comments;
	private Set<Upload> uploads;
	private DiscussionStatus discussionStatus;

	public Page() {
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return contentText;
	}

	public void setContent(String content) {
		this.contentText = content;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Set<Upload> getUploads() {
		return uploads;
	}

	public void setUploads(Set<Upload> uploads) {
		this.uploads = uploads;
	}

	public DiscussionStatus getDiscussionStatus() {
		return discussionStatus;
	}

	public void setDiscussionStatus(DiscussionStatus discussionStatus) {
		this.discussionStatus = discussionStatus;
	}
}
