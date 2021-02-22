package com.github.small.ac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;
import static com.github.apeforge.ironape.commons.util.Util.*;

@Entity
@Table(name = "tb_session", schema = "ironape")
public class Session extends BaseEntity {

	private static final long serialVersionUID = 2779920911468962187L;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "session")
	private List<SessionRole> sessionRoles;

	public Session() {
		this(null);
	}

	public Session(User user) {
		super();
		setUser(user);
		setSessionRoles(sessionRoles);
	}

	// session_user(s:SESSIONS)
	public User getUser() {
		return user;
	}
	
	public List<SessionRole> getSessionRoles() {
		return sessionRoles;
	}
	
	public void setUser(User user) {
		this.setUser(user, true);
	}

	public void setUser(User user, boolean bidirectional) {
		if (bidirectional) {
			if(this.user != null) {
				this.user.removeSession(this);
			}
			if(user != null) {
				user.addSession(this);
			}
		} else {
			this.user = user;
		}
	}

	public void setSessionRoles(List<SessionRole> sessionRoles) {
		this.sessionRoles = sessionRoles;
		
		if (isEmpty(sessionRoles)){
			this.sessionRoles = new ArrayList<SessionRole>();
		} else {
			this.sessionRoles = sessionRoles;
			for (SessionRole i : sessionRoles) {
				if(i != null && i.getSession() != this)
					i.setSession(this);
			}
		}
	}

	public void addSessionRole(SessionRole sessionRole) {
		if(isNotIn(sessionRoles, sessionRole)) {
			sessionRoles.add(sessionRole);
			sessionRole.setSession(this, false);
		}
	}
	
	public void removeSessionRole(SessionRole sessionRole) {
		if(isIn(sessionRoles, sessionRole)) {
			sessionRoles.remove(sessionRole);
			sessionRole.setSession(null, false);
		}
	}
	
	public boolean containsSessionRole(SessionRole sessionRole) {
		return isNotEmpty(sessionRoles)
				&& sessionRoles.contains(sessionRole);
	}

	// session_roles(s:SESSIONS)
	public List<Role> getRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (SessionRole i : this.getSessionRoles()) {
			roles.add(i.getRole());
		}
		return roles;
	}

	public List<Permission> getPermissions(){
		List<Permission> permissions = new ArrayList<Permission>();
		
		for(Role i : this.getRoles()) {
			for(Permission j : i.getAssignedPermissions()){
				if(isNotIn(permissions, j)){
					permissions.add(j);
				}
			}
		}
		return permissions;
	}
	// TODO
	// avail_session_perms(s:SESSIONS)
	public List<Permission> getAvailablePermissions() throws Exception{
		throw new Exception("Not implemented.");
	}
}
