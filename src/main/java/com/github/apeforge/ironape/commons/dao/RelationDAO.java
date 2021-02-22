package com.github.apeforge.ironape.commons.dao;

// TODO: Use generic
public interface RelationDAO<T, K, A, B> {

	T findPair(K id1, K id2);

}
