package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseDAO;
import com.github.small.ac.entity.Role;

public class RoleDAO extends BaseDAO<Role, UUID> {

	public RoleDAO(EntityManager em) {
		super(em, Role.class);
	}

}
