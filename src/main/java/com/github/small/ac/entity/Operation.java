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
@Table(name = "tb_operation", schema = "ironape")
public class Operation extends BaseEntity {

	private static final long serialVersionUID = -8916973203411754846L;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "operation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Permission> permissions;

	public Operation() {
		this(null);
	}

	public Operation(String name) {
		super();
		this.name = name;
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
				if (i.getOperation() != this)
					i.setOperation(this);
			}
		}
	}

	public void addPermission(Permission permission) {
		if (isNotIn(permissions, permission)) {
			this.permissions.add(permission);
			permission.setOperation(this, false);
		}
	}

	public void removePermission(Permission permission) {
		if (isIn(permissions, permission)) {
			this.permissions.remove(permission);
			permission.setOperation(null, false);
		}
	}

}
