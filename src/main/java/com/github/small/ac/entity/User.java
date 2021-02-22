package com.github.small.ac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;
import com.github.apeforge.ironape.commons.entity.BaseEnum;
import static com.github.apeforge.ironape.commons.util.Util.*;

@Entity
@Table(name = "tb_user", schema = "ironape")
public class User extends BaseEntity {

	private static final long serialVersionUID = 491460511141832093L;

	@Column(name = "status", length = 1)
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	@Column(name = "name")
	private String name;

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "user")
	private List<UserAssignment> userAssignments;
	
	@OneToMany(mappedBy = "user")
	private List<Session> sessions;

	public enum UserStatus implements BaseEnum {
		; // TODO

		private final String name;

		UserStatus(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	public User() {
		this(null, null, null, null);
	}

	public User(String login) {
		this(null, login, null, null);
	}

	public User(String login, String email) {
		this(null, login, email, null);
	}

	public User(String name, String login, String email) {
		this(name, login, email, null);
	}

	public User(String name, String login, String email, String password) {
		super();
		this.name = name;
		this.login = login;
		this.email = email;
		this.password = password;

		init();
	}

	private void init() {

		if (this.name == null)
			this.name = this.login;

		setUserAssignments(userAssignments);
		setSessions(sessions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserAssignment> getUserAssignments() {
		return userAssignments;
	}

	public void setUserAssignments(List<UserAssignment> userAssignments) {

		if (isEmpty(userAssignments))
			this.userAssignments = new ArrayList<UserAssignment>();
		else {
			this.userAssignments = userAssignments;
			for (UserAssignment i : userAssignments) {
				if (i.getUser() != this)
					i.setUser(this);
			}
		}
	}

	public void addUserAssignment(UserAssignment userAssignment) {
		if(isNotIn(userAssignments, userAssignment)){
			userAssignments.add(userAssignment);
			userAssignment.setUser(this, false);
		}
	}
	
	public void removeUserAssignment(UserAssignment userAssignment) {
		if(isIn(userAssignments, userAssignment)){
			this.userAssignments.remove(userAssignment);
			userAssignment.setUser(null, false);
		}
	}
	
	public List<Role> getAssignedRoles() {

		ArrayList<Role> roles = new ArrayList<Role>();
		for (UserAssignment i : this.getUserAssignments()) {
			if(isNotIn(roles, i))
				roles.add(i.getRole());
		}
		return roles;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		
		if (isEmpty(sessions))
			this.sessions = new ArrayList<Session>();
		else {
			this.sessions = sessions;
			for (Session i : sessions) {
				if ((i != null) && i.getUser() != this)
					i.setUser(this);
			}
		}
	}
	
	public void addSession(Session session) {
		if(isNotIn(sessions, session)) {
			sessions.add(session);
			session.setUser(this, false);
		}
	}
	
	public void removeSession(Session session) {
		if(isIn(sessions, session)) {
			sessions.remove(session);
			session.setUser(null, false);
		}
	}
	
	public List<Permission> getPermissions() {
		List<Permission> permissions = new ArrayList<Permission>();
		for (Role i : this.getAssignedRoles()) {
			for (Permission j : i.getAssignedPermissions()){
				if (isNotIn(permissions, j)){
					permissions.add(j);
				}
			}
		}
		return permissions;
	}
	
	public List<Operation> getOperationsOnObject(Object object) {
		List<Operation> operations = new ArrayList<Operation>();
		for (Permission i : this.getPermissions()) {
			if ((i != null) && i.getObject().equals(object))
				operations.add(i.getOperation());
		}
		return operations;
	}
}
