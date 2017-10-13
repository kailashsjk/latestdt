package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;


@Named
public class DTIdeaGroupDAO extends BaseDAO<IdeaGroup, Serializable> implements IDTIdeaGroupDAO{

	@Override
	public List<IdeaGroup> getIdeaGroupDetailsByProjectID(int projectId) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<IdeaGroup> query = builder.createQuery(IdeaGroup.class);
	    Root<IdeaGroup> ideagroup = query.from(IdeaGroup.class);
	   // Root<Media> media = query.from(Media.class);	   
	    Root<Project> project = query.from(Project.class);
	    TypedQuery<IdeaGroup> typedQuery = entityManager.createQuery(query
	    		.select(ideagroup)
	            .where(builder.and(
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(ideagroup.get("project"), project),
	                    //builder.equal(observation.get("media"), media),
	                    builder.equal(ideagroup.get("deleteFlag"), 0)	
	                    
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public List<IdeaGroup> getAllIdeaGroupDetailsByProjectID(int projectId) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<IdeaGroup> query = builder.createQuery(IdeaGroup.class);
	    Root<IdeaGroup> ideagroup = query.from(IdeaGroup.class);
	    Root<Media> media = query.from(Media.class);	   
	    Root<Project> project = query.from(Project.class);
	    TypedQuery<IdeaGroup> typedQuery = entityManager.createQuery(query
	    		.select(ideagroup)
	            .where(builder.and(
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(ideagroup.get("project"), project)
	                    //builder.equal(observation.get("media"), media),
	                 //   builder.equal(ideagroup.get("deleteFlag"), 0)	
	                    
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public void deleteIdeaGroup(int IGID) {
		IdeaGroup ideagroup = read(IGID);
		ideagroup.setDeleteFlag(1);
		
	}

	@Override
	public void activateIdeaGroup(int IGID) {
		IdeaGroup ideagroup = read(IGID);
		ideagroup.setDeleteFlag(0);
		
	}


}
