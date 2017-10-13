package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.User;
@Named
public class UserDAO extends BaseDAO<User, Serializable> implements IUserDAO {

	@Override
	public List<User> getUserDetailsByUserId(String userId,String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery =criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery
	    		.select(user)
	            .where(criteriaBuilder.and(
	            		criteriaBuilder.equal(user.get("userId"),userId),
	            		criteriaBuilder.equal(user.get("password"), password),
	            		criteriaBuilder.equal(user.get("active"),0)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
        
        
	}
}
