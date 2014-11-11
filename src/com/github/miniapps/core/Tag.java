package com.github.miniapps.core;

public abstract class Tag {

	protected int id;
	protected String name;
	protected String label;
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
		return label;
	}

	public void setSlug(String label) {
		this.label = label;
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
