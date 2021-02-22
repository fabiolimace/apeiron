package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseRelationDAO;
import com.github.small.ac.entity.Permission;
import com.github.small.ac.entity.PermissionAssignment;
import com.github.small.ac.entity.Role;

public class PermissionAssignmentDAO extends BaseRelationDAO<PermissionAssignment, UUID, Permission, Role> {

	public PermissionAssignmentDAO(EntityManager em) {
		super(em, PermissionAssignment.class, Permission.class, Role.class);
	}

	public PermissionAssignment findPair(UUID permissionId, UUID roleId) {
		return findPairByIds(permissionId, roleId);
	}
}
