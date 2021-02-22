package com.github.apeforge.ironape.commons.dao;

import java.util.List;

// TODO: Use generic
public interface DAO<T, K> {

	void insert(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> list();

	T find(K id);
	
	boolean exists(T entity);
	//boolean isPersistent(T entity);
	//boolean isManaged(T entity);
}
