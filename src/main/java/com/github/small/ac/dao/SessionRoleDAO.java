package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseRelationDAO;
import com.github.small.ac.entity.Role;
import com.github.small.ac.entity.Session;
import com.github.small.ac.entity.SessionRole;

public class SessionRoleDAO extends BaseRelationDAO<SessionRole, UUID, Session, Role> {

	public SessionRoleDAO(EntityManager em) {
		super(em, SessionRole.class, Session.class, Role.class);
	}
	
	public SessionRole findPair(UUID sessionid, UUID roleid) {
		return findPairByIds(sessionid, roleid);
	}
}
