package com.github.small.ac.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name = "tb_session_role", schema = "ironape")
public class SessionRole extends BaseEntity {

	private static final long serialVersionUID = 5345180885481037017L;

	@ManyToOne
	@JoinColumn(name = "session_id", nullable = false)
	private Session session;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	public SessionRole() {
		this(null, null);
	}

	public SessionRole(Session session, Role role) {
		super();		
		setSession(session);
		setRole(role);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.setSession(session, true);
	}
	
	protected void setSession(Session session, boolean bidirectional) {
		if(bidirectional) {
			if(this.session != null) {
				this.session.removeSessionRole(this);
			}
			if(session != null) {
				session.addSessionRole(this);
			}
		} else {
			this.session = session;
		}
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
				this.role.removeSessionRole(this);
			}
			if (role != null) {
				role.addSessionRole(this);
			}
		} else {
			this.role = role;
		}
	}

}
