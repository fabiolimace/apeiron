package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseRelationDAO;
import com.github.small.ac.entity.Role;
import com.github.small.ac.entity.User;
import com.github.small.ac.entity.UserAssignment;

public class UserAssignmentDAO extends
		BaseRelationDAO<UserAssignment, UUID, User, Role> {

	public UserAssignmentDAO(EntityManager entityManager) {
		super(entityManager, UserAssignment.class, User.class, Role.class);
	}

	public UserAssignment findPair(UUID userid, UUID roleid) {
		return findPairByIds(userid, roleid);
	}

}
