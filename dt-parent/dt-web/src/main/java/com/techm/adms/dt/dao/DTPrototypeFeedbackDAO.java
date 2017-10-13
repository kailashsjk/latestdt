package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import com.techm.adms.dt.entity.PrototypeFeedback;

@Named
public class DTPrototypeFeedbackDAO extends BaseDAO<PrototypeFeedback, Serializable> implements IDTPrototypeFeedbackDAO {
	@Override
	public List<PrototypeFeedback> getPrototypeFeedbackByProjectId(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PrototypeFeedback> query = builder.createQuery(PrototypeFeedback.class);
	    Root<PrototypeFeedback> prototypeFeedback = query.from(PrototypeFeedback.class);
	   
	    Root<IdeaGroup> ideaGroup = query.from(IdeaGroup.class);
	 
	    Root<Prototype> prototype = query.from(Prototype.class);
	    
	    Root<Project> project = query.from(Project.class);
	   
	    TypedQuery<PrototypeFeedback> typedQuery = entityManager.createQuery(query
	    		.select(prototypeFeedback)
	            .where(builder.and(
	 
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(ideaGroup.get("project"), project),
	                    builder.equal(prototype.get("ideaGroup"), ideaGroup),
	                    builder.equal(prototypeFeedback.get("prototype"), prototype)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public List<PrototypeFeedback> getPrototypeFeedbackByProjectIdActiveDatas(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PrototypeFeedback> query = builder.createQuery(PrototypeFeedback.class);
	    Root<PrototypeFeedback> prototypeFeedback = query.from(PrototypeFeedback.class);
	   
	    Root<IdeaGroup> ideaGroup = query.from(IdeaGroup.class);
	 
	    Root<Prototype> prototype = query.from(Prototype.class);
	    
	    Root<Project> project = query.from(Project.class);
	   
	    TypedQuery<PrototypeFeedback> typedQuery = entityManager.createQuery(query
	    		.select(prototypeFeedback)
	            .where(builder.and(
	 
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(ideaGroup.get("project"), project),
	                    builder.equal(prototype.get("ideaGroup"), ideaGroup),
	                    builder.equal(prototypeFeedback.get("prototype"), prototype),
	                    builder.equal(prototypeFeedback.get("deleteFlag"), 0)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public void deletePrototypeFeedback(PrototypeFeedback prototypeFeedback) {
		PrototypeFeedback prototypeFeedbacks = read(prototypeFeedback.getPrototypeFeedbackID());
		Calendar calendar = Calendar.getInstance();
	    Date date =  calendar.getTime();
	    prototypeFeedbacks.setDeleteFlag(1);
	    prototypeFeedbacks.setCreatedDate(date);
		
		}

}
