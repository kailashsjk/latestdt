package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.User;

public class DTAssignedRolesDAO extends BaseDAO<AssignRoles, Serializable> implements IDTAssignedRolesDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTRoleManagementDAO.class);
	
	@Override
	public List<AssignRoles> getUserRolesbyProjectId(int projectId, int userId){
		
		LOGGER.info("Inside DTRoleManagementDAO");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<AssignRoles> query = builder.createQuery(AssignRoles.class);
	    Root<AssignRoles> assignRoles = query.from(AssignRoles.class);
	    Root<Project> project = query.from(Project.class);
	    Root<User> user=query.from(User.class);
	    TypedQuery<AssignRoles> typedQuery = entityManager.createQuery(query
	    		.select(assignRoles)
	            .where(builder.and(
	            		builder.equal(assignRoles.get("project"),project),
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(assignRoles.get("logInUser"),user),
	                    builder.equal(user.get("id"),userId)
	                    
	            )).distinct(true)
	    );
	   LOGGER.info("DTRoleManagementDAO getUserRolesbyProjectId::>>"+typedQuery.getResultList());
		return typedQuery.getResultList();		
	}
	
	@Override
	public List<AssignRoles> getUserRolesbyProjectId(int projectId){
		
		LOGGER.info("Inside DTRoleManagementDAO");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<AssignRoles> query = builder.createQuery(AssignRoles.class);
	    Root<AssignRoles> assignRoles = query.from(AssignRoles.class);
	    Root<Project> project = query.from(Project.class);
	    Root<User> user=query.from(User.class);
		TypedQuery<AssignRoles> typedQuery = entityManager.createQuery(query
	    		.select(assignRoles)
	            .where(
	            		builder.equal(assignRoles.get("project"),project),
	                    builder.equal(project.get("projectId"), projectId)  
	            )
	            .distinct(true)
	            .orderBy(builder.asc(user.get("userId")))
	    );
	    LOGGER.info("DTRoleManagementDAO getUserRolesbyProjectId::>>"+typedQuery.getResultList());
		return typedQuery.getResultList();
	}
	
	@Override
	public List<AssignRoles> getUserRolesbyUserId(int userId){
		
		LOGGER.info("Inside DTRoleManagementDAO");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<AssignRoles> query = builder.createQuery(AssignRoles.class);
	    Root<AssignRoles> assignRoles = query.from(AssignRoles.class);
	    Root<User> user=query.from(User.class);
	    Root<Project> project = query.from(Project.class);
		TypedQuery<AssignRoles> typedQuery = entityManager.createQuery(query
	    		.select(assignRoles)
	            .where(
	            		builder.equal(assignRoles.get("logInUser"),user),
	                    builder.equal(user.get("id"),userId)  
	            )
	            .distinct(true)
	            .orderBy(builder.asc(project.get("projectId")))
	    );
	    LOGGER.info("DTRoleManagementDAO getUserRolesbyUserId::>>"+typedQuery.getResultList());
		return typedQuery.getResultList();
	}
}
