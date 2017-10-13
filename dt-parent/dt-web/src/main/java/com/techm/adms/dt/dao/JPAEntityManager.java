package com.techm.adms.dt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManager<T> {

	private static EntityManagerFactory entityManagerFactory = null;

	public JPAEntityManager() {
	}

	public static void initialize() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "DesignThinking" );
	}

	public T save(T t) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();

		return t;
	}
	
	public T query(T t,Long id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(t.getClass(),id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return t;
	}

}
