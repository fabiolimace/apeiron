package com.github.miniapps.core;

public class Comment extends Content {

	protected String authorIP;
	protected String authorName;
	protected String authorEmail;
	protected String authorWebsite;
	protected String authorLocation;
	protected String commentText;

	public Comment() {
		super();
	}

	public String getIp() {
		return authorIP;
	}

	public void setIp(String authorIP) {
		this.authorIP = authorIP;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getAuthorWebsite() {
		return authorWebsite;
	}

	public void setAuthorWebsite(String authorWebsite) {
		this.authorWebsite = authorWebsite;
	}

	public String getAuthorLocation() {
		return authorLocation;
	}

	public void setAuthorLocation(String authorLocation) {
		this.authorLocation = authorLocation;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

}
