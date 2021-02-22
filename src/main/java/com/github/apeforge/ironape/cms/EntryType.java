package com.github.apeforge.ironape.cms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name = "tb_entry_type", schema="ironape")
@Inheritance(strategy = InheritanceType.JOINED)
public class EntryType extends BaseEntity {

	private static final long serialVersionUID = 8446295341348250069L;
	
	@Column(name = "name")
	protected String name;
	
	@OneToMany(mappedBy="type")
	protected List<Entry> entries;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	protected EntryType parent;

	@OneToMany(mappedBy = "parent")
	protected List<EntryType> children;

	public EntryType() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public EntryType getParent() {
		return parent;
	}

	public void setParent(EntryType parent) {
		this.parent = parent;
	}

	public List<EntryType> getChildren() {
		return children;
	}

	public void setChildren(List<EntryType> children) {
		this.children = children;
	}

}
