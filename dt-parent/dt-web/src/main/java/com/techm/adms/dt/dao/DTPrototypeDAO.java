package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.Prototype;


@Named
public class DTPrototypeDAO extends BaseDAO<Prototype, Serializable> implements IDTPrototypeDAO {
	
		@Override
		public List<Prototype> getPrototypeDetailByProjectId(int projectId){
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<Prototype> query = builder.createQuery(Prototype.class);
		 
		    Root<Project> project = query.from(Project.class);
		    Root<Prototype> prototype = query.from(Prototype.class);
		    Root<IdeaGroup> ideagroup = query.from(IdeaGroup.class);
		   
		    TypedQuery<Prototype> typedQuery = entityManager.createQuery(query
		    		.select(prototype)
		            .where(builder.and(
		            		
		                    builder.equal(project.get("projectId"),projectId),
			                builder.equal(ideagroup.get("project"), project),
	                   		builder.equal(prototype.get("ideaGroup"), ideagroup),
	                        builder.equal(prototype.get("deleteFlag"), 0)
	                     
		            )).distinct(true)
		    );
		    return typedQuery.getResultList();
		}
		
		@Override
		public List<Prototype> getPrototypeForPrototypeFeedback(int projectId){

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<Prototype> query = builder.createQuery(Prototype.class);
		 
		    Root<Project> project = query.from(Project.class);
		    Root<Prototype> prototype = query.from(Prototype.class);
		    Root<IdeaGroup> ideagroup = query.from(IdeaGroup.class);
		   
		    TypedQuery<Prototype> typedQuery = entityManager.createQuery(query
		    		.select(prototype)
		            .where(builder.and(
		            		
		                    builder.equal(project.get("projectId"),projectId),
			                builder.equal(ideagroup.get("project"), project),
	                   		builder.equal(prototype.get("ideaGroup"), ideagroup),	
	                   		builder.equal(prototype.get("deleteFlag"), 0),
	                        builder.equal(prototype.get("test"), 1)
	                     
		            )).distinct(true)
		    );
		    return typedQuery.getResultList();
		}
		
		@Override
		public List<Prototype> getDTPrototypeDetailByProjectId(int projectId){
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<Prototype> query = builder.createQuery(Prototype.class);
		    Root<Project> project = query.from(Project.class);
		    Root<Prototype> prototype = query.from(Prototype.class);
		    Root<IdeaGroup> ideagroup = query.from(IdeaGroup.class);
		    TypedQuery<Prototype> typedQuery = entityManager.createQuery(query
		    		.select(prototype)
		            .where(builder.and(
		            		 builder.equal(project.get("projectId"),projectId),
				                builder.equal(ideagroup.get("project"), project),
		                   		builder.equal(prototype.get("ideaGroup"), ideagroup)
		            )).distinct(true)
		    );
		    return typedQuery.getResultList();
		}

		@Override
		public void delete(int prototypeId) {
			Prototype prototype = read(prototypeId);
			prototype.setDeleteFlag(1);
			
		} 
			
		@Override
		public void activate(int prototypeId) {
			Prototype prototype = read(prototypeId);
			prototype.setDeleteFlag(0);
			
		}
		
		@Override
		public Prototype getPrototypeDetailsByUniqueId(String uniqueId) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
	        Root prototype = criteriaQuery.from(Prototype.class);
	        criteriaQuery.multiselect(prototype);
	        CriteriaQuery result = criteriaQuery.where(criteriaBuilder.equal(prototype.get("uniqueId"),uniqueId));
	        TypedQuery query = entityManager.createQuery(result);
	        return (Prototype) query.getSingleResult();
		}

}
