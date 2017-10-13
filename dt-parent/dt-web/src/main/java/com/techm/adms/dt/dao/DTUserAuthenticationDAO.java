package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.DTUserAuthenticationBean;

@Named
public class DTUserAuthenticationDAO extends BaseDAO<User, Serializable> implements IDTUserAuthenticationDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DTUserAuthenticationDAO.class);

	@Override
	public User getCredentials(String userId) {
		User user = null;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder
				.createQuery();
		Root<User> rootEntry = criteriaQuery.from(User.class);
		criteriaQuery.multiselect(rootEntry);
		CriteriaQuery result = criteriaQuery.where(criteriaBuilder.equal(
				rootEntry.get("userId"), userId));
		TypedQuery query = entityManager.createQuery(result);
		if(query.getResultList() != null && query.getResultList().size() > 0){
			user = (User) query.getResultList().get(0);
		}
		return 	user;
	}
}
