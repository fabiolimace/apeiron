package com.github.apeforge.ironape.commons.util;

import javax.enterprise.inject.Disposes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ironape");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void destroyEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
