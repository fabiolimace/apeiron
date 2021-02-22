package com.github.apeforge.ironape.commons.dao;

import java.lang.reflect.Field;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.github.apeforge.ironape.commons.util.IronApeException;

public abstract class BaseRelationDAO<T, K, A, B> extends BaseDAO<T, K>
		implements RelationDAO<T, K, A, B> {

	protected EntityManager entityManager;

	protected Class<T> clazz;
	protected Class<A> referencedClazz1;
	protected Class<B> referencedClazz2;

	protected String clazzName;
	protected String foreingKeyName1;
	protected String foreingKeyName2;

	public BaseRelationDAO(EntityManager entityManager, Class<T> clazz,
			Class<A> class1, Class<B> class2) {
		super(entityManager, clazz);

		this.entityManager = entityManager;

		this.clazz = clazz;

		this.referencedClazz1 = class1;
		this.referencedClazz2 = class2;

		this.init();
	}

	protected void init() {
		this.clazzName = clazz.getName();

		this.initForeignKeyNames();
	}

	protected void initForeignKeyNames() {
		try {
			this.foreingKeyName1 = findForeingKeyName(referencedClazz1);
			this.foreingKeyName2 = findForeingKeyName(referencedClazz2);
		} catch (IronApeException e) {
			e.printStackTrace();
		}
	}

	protected String getFindPairByIdsQueryString(Class<?> referencedClazz1,
			Class<?> referencedClazz2) {

		String queryString = "select o from " + clazzName + " o";
		queryString = queryString + " where ";
		queryString = queryString + " o." + foreingKeyName1 + ".id = ";
		queryString = queryString + "  :" + foreingKeyName1 + "id ";
		queryString = queryString + " and ";
		queryString = queryString + " o." + foreingKeyName2 + ".id = ";
		queryString = queryString + "  :" + foreingKeyName2 + "id ";

		System.out.println("QUERY: " + queryString);

		return queryString;
	}

	protected String findForeingKeyName(Class<?> referencedClazz)
			throws IronApeException {

		int count = 0;
		String foreingKeyName = null;

		for (Field field : clazz.getDeclaredFields()) {
			if (field.getType() == referencedClazz) {
				foreingKeyName = field.getName();
				count++;
			}
		}

		if (count != 1)
			throw new IronApeException("The quantity of fields of "
					+ referencedClazz.getSimpleName() + " expected is 1, but "
					+ count + " fields was found.");

		return foreingKeyName;
	}

	protected T findPairByIds(UUID id1, UUID id2) {

		String queryStr = getFindPairByIdsQueryString(referencedClazz1,
				referencedClazz2);

		TypedQuery<T> query = entityManager.createQuery(queryStr, clazz);

		query.setParameter(foreingKeyName1 + "id", id1);
		query.setParameter(foreingKeyName2 + "id", id2);

		return query.getSingleResult();
	}

}
