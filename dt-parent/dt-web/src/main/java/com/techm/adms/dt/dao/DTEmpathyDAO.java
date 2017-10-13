package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Named
public class DTEmpathyDAO extends BaseDAO<Observation, Serializable> implements IDTEmpathyDAO{
	
	@Override
	public List<Observation> getEmpathyList(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Observation> query = builder.createQuery(Observation.class);
	    Root<Observation> observation = query.from(Observation.class);
	    Root<Media> media = query.from(Media.class);	   
	    Root<Project> project = query.from(Project.class);
	    TypedQuery<Observation> typedQuery = entityManager.createQuery(query
	    		.select(observation)
	            .where(builder.and(
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(media.get("project"), project),
	                    builder.equal(observation.get("media"), media),
	                    builder.equal(observation.get("deleteFlag"), 0)	
	                    
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
}
