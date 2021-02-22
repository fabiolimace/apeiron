package com.github.small.ac.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name = "tb_permission_grant", schema = "ironape")
public class PermissionAssignment extends BaseEntity {

	private static final long serialVersionUID = 8147721080580819873L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "permission_id", nullable = false)
	private Permission permission;

	public PermissionAssignment() {
		this(null, null);
	}

	public PermissionAssignment(Permission permission, Role role) {
		super();
		setPermission(permission);
		setRole(role);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.setRole(role, true);
	}

	public void setRole(Role role, boolean bidirectional) {
		if (bidirectional) {
			if (this.role != null) {
				this.role.removePermissionAssignment(this);
			}
			if (role != null) {
				role.addPermissionAssignment(this);
			}
		} else {
			this.role = role;
		}
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.setPermission(permission, true);
	}

	public void setPermission(Permission permission, boolean bidirectional) {
		if (bidirectional) {
			if (this.permission != null) {
				this.permission.removePermissionAssignment(this);
			}
			if (permission != null) {
				permission.addPermissionAssignment(this);
			}
		} else {
			this.permission = permission;
		}
	}
}
