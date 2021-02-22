package com.github.small.ac.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.github.apeforge.ironape.commons.dao.BaseDAO;
import com.github.small.ac.entity.User;

public class UserDAO extends BaseDAO<User, UUID> {

	public UserDAO(EntityManager em) {
		super(em, User.class);
	}
}
