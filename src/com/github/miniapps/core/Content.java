package com.github.miniapps.core;

import java.util.Date;
import java.util.Set;

public class Content {

	protected int id;
	protected ContentType type;
	protected ContentStatus status;
	protected Date createDate;
	protected Date updateDate;
	protected Date publishDate;
	protected Date unpublishDate;
	protected User author;
	protected Set<Tag> tags;
	protected Set<Property> properties;
	protected Content parent;
	protected Set<Content> children;
	protected Content original;
	protected Content current;
	protected Set<Content> revisions;

	public Content() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ContentType getType() {
		return type;
	}

	public void setType(ContentType type) {
		this.type = type;
	}

	public ContentStatus getStatus() {
		return status;
	}

	public void setStatus(ContentStatus status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getUnpublishDate() {
		return unpublishDate;
	}

	public void setUnpublishDate(Date unpublishDate) {
		this.unpublishDate = unpublishDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Content getParent() {
		return parent;
	}

	public void setParent(Content parent) {
		this.parent = parent;
	}

	public Set<Content> getChildren() {
		return children;
	}

	public void setChildren(Set<Content> children) {
		this.children = children;
	}

	public Content getOriginal() {
		return original;
	}

	public void setOriginal(Content original) {
		this.original = original;
	}

	public Content getCurrent() {
		return current;
	}

	public void setCurrent(Content current) {
		this.current = current;
	}

	public Set<Content> getRevisions() {
		return revisions;
	}

	public void setRevisions(Set<Content> revisions) {
		this.revisions = revisions;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

}
