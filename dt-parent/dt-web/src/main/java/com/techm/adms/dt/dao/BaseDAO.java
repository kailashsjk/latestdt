package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.entity.Project;


public class BaseDAO<T, PK extends Serializable> implements IBaseDAO<T, PK> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDAO.class);
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;
    
    public BaseDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        LOGGER.info("base DAO #### entityManager ####"+entityManager);
        LOGGER.info("base DAO #### entityClass ####"+entityClass);
    }
	
    public T create(T t) {
		LOGGER.info("base DAO create  #### entityManager ####"+entityManager);
		this.entityManager.persist(t);
        return t;
	}

	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	public List<T> readAll(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
	public List<T> readAllByDeleteFlag(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        criteriaQuery.select(rootEntry);
        CriteriaQuery<T> result = criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("deleteFlag"),0));
        TypedQuery<T> query = entityManager.createQuery(result);
        return query.getResultList();
	}
	
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	public void delete(T t) {
		 t = this.entityManager.merge(t);
		 this.entityManager.remove(t);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
