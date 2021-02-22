package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseDAO;
import com.github.small.ac.entity.Operation;

public class OperationDAO extends BaseDAO<Operation, UUID> {

	public OperationDAO(EntityManager em) {
		super(em, Operation.class);
	}
}
