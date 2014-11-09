package com.github.miniapps.core;

public class Tag {

	protected int id;
	protected String slug;
	protected String name;
	protected TagSet tagSet;

	public Tag() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public TagSet getTagSet() {
		return tagSet;
	}

	public void setTagSet(TagSet tagSet) {
		this.tagSet = tagSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
