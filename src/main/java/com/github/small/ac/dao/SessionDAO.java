package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseDAO;
import com.github.small.ac.entity.Session;

public class SessionDAO extends BaseDAO<Session, UUID> {

	public SessionDAO(EntityManager em) {
		super(em, Session.class);
	}
}
