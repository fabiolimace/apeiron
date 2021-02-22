package com.github.small.ac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name="tb_parameter", schema="ironape")
public class Parameter extends BaseEntity {

	private static final long serialVersionUID = -6115318093725947626L;

	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;
	
	public Parameter() {
		super();
	}
	
	public Parameter(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
