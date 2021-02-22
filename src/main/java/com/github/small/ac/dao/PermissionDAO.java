package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseRelationDAO;
import com.github.small.ac.entity.Object;
import com.github.small.ac.entity.Operation;
import com.github.small.ac.entity.Permission;

public class PermissionDAO extends
		BaseRelationDAO<Permission, UUID, Object, Operation> {

	public PermissionDAO(EntityManager entityManager) {
		super(entityManager, Permission.class, Object.class, Operation.class);
	}

	public Permission findPair(UUID resourceid, UUID operationid) {
		return super.findPairByIds(resourceid, operationid);
	}

}
