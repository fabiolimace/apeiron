package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseDAO;
import com.github.small.ac.entity.Object;

public class ResourceDAO extends BaseDAO<Object, UUID> {

	public ResourceDAO(EntityManager em) {
		super(em, Object.class);
	}
}
