package com.github.small.ac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;
import static com.github.apeforge.ironape.commons.util.Util.*;

@Entity
@Table(name = "tb_object", schema = "ironape")
public class Object extends BaseEntity { 

	private static final long serialVersionUID = -2178433618340576060L;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "object", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Permission> permissions;

	public Object() {
		this(null);
	}

	public Object(String name) {
		super();
		this.name = name;

		init();
	}

	private void init() {
		this.setPermissions(permissions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {

		if (isEmpty(permissions)) {
			this.permissions = new ArrayList<Permission>();
		} else {

			this.permissions = permissions;
			for (Permission i : permissions) {
				if (i.getObject() != this)
					i.setObject(this);
			}
		}
	}

	public void addPermission(Permission permission) {
		if (isNotIn(permissions, permission)) {
			permissions.add(permission);
			permission.setObject(this, false);
		}
	}

	public void removePermission(Permission permission) {
		if (isIn(permissions, permission)) {
			permissions.remove(permission);
			permission.setObject(null, false);
		}
	}
}
