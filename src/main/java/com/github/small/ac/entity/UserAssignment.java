package com.github.small.ac.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name = "tb_user_assignment", schema = "ironape")
public class UserAssignment extends BaseEntity {

	private static final long serialVersionUID = 8336610593295917795L;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	public UserAssignment() {
		this(null, null);
	}

	public UserAssignment(User user, Role role) {
		super();
		setUser(user);
		setRole(role);
	}

	public User getUser() {
		return user;
	}
	
	void internalSetUser(User user){
		this.user = user;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setUser(User user) {
		this.setUser(user, true);
	}
	
	public void setRole(Role role) {
		this.setRole(role, true);
	}
	
	public void setUser(User user, boolean bidirectional) {
		if (bidirectional) {
			if (this.user != null) {
				this.user.removeUserAssignment(this);
			}
			if (user != null) {
				user.addUserAssignment(this);
			}
		} else {
			this.user = user;
		}
	}
	
	public void setRole(Role role, boolean bidirectional) {
		if (bidirectional) {
			if (this.role != null) {
				role.removeUserAssignment(this);
			}
			if (role != null) {
				role.addUserAssignment(this);
			}
		} else {
			this.role = role;
		}
	}
}
