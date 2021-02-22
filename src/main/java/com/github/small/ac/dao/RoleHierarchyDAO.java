package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseRelationDAO;
import com.github.small.ac.entity.Role;
import com.github.small.ac.entity.RoleHierarchy;

public class RoleHierarchyDAO extends
		BaseRelationDAO<RoleHierarchy, UUID, Role, Role> {

	public RoleHierarchyDAO(EntityManager entityManager) {
		super(entityManager, RoleHierarchy.class, Role.class, Role.class);
	}
	
	@Override
	protected void initForeignKeyNames(){
		this.foreingKeyName1 = "ascendantRole";
		this.foreingKeyName2 = "descendantRole";
	}
	
	public RoleHierarchy findPair(UUID ascendantRoleId, UUID descendantRoleId) {
		return findPairByIds(ascendantRoleId, descendantRoleId);
	}

}
