package com.github.apeforge.ironape.commons.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class BaseDAO<T, K> implements DAO<T, K> {

	protected EntityManager entityManager;
	protected Class<T> clazz;
	protected String clazzName;

	public BaseDAO(EntityManager entityManager, Class<T> clazz) {
		this.entityManager = entityManager;
		this.clazz = clazz;
		this.clazzName = clazz.getName();
	}

	public void insert(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<T> list() {
		TypedQuery<T> query = entityManager.createQuery(("from " + clazzName),
				clazz);
		return query.getResultList();
	}

	public T find(K id) {
		return (T) entityManager.find(clazz, id);
	}
	
	public boolean exists(T entity) {
		return ((isManaged(entity)) || (isPersistent(entity)));
	}

	public boolean isPersistent(T entity) {
		String queryStr = "select 1 from " + clazzName + " o where o = :o";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("o", entity);
		query.setMaxResults(1);
		return (query.getResultList().size() > 0);
	}

	public boolean isManaged(T entity) {
		return (entityManager.contains(entity));
	}

	public boolean isDetached(T entity) {
		return (!isManaged(entity));
	}
}
