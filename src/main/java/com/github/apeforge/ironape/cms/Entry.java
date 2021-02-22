

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
@Table(name = "tb_entry", schema="ironape")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Entry extends BaseEntity {

	private static final long serialVersionUID = -352531719522515973L;

	@Column(name = "name")
	protected String name;

	@ManyToOne
	@JoinColumn(name = "type_id")
	protected EntryType type;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	protected Entry parent;

	@OneToMany(mappedBy = "parent")
	protected List<Entry> children;

	public Entry() {
		super();
	}

	public Entry(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}

	public Entry getParent() {
		return parent;
	}

	public void setParent(Entry parent) {
		parent.addChild(this);
		this.parent = parent;
	}

	public List<Entry> getChildren() {
		return children;
	}

	public void setChildren(List<Entry> children) {
		for (Entry i : children) {
			i.setParent(this);
		}
		this.children = children;
	}
	
	public void addChild(Entry entry) {
		this.children.add(entry);
	}

}
