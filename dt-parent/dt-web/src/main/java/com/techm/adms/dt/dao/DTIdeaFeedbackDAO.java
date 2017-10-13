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
import com.techm.adms.dt.entity.IdeaFeedback;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Named
public class DTIdeaFeedbackDAO extends BaseDAO<IdeaFeedback, Serializable> implements IDTIdeaFeedbackDAO {
	@Override
	public List<IdeaFeedback> getIdeaFeedbackByProjectId(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<IdeaFeedback> query = builder.createQuery(IdeaFeedback.class);
	    Root<IdeaFeedback> ideaFeedback = query.from(IdeaFeedback.class);
	  
	    Root<Idea> idea = query.from(Idea.class);
	  
	    Root<Project> project = query.from(Project.class);
	    TypedQuery<IdeaFeedback> typedQuery = entityManager.createQuery(query
	    		.select(ideaFeedback)
	            .where(builder.and(
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(idea.get("project"), project),	                  
	                    builder.equal(ideaFeedback.get("idea"), idea)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public List<IdeaFeedback> getIdeaFeedbackByProjectIdActiveDatas(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<IdeaFeedback> query = builder.createQuery(IdeaFeedback.class);
	    Root<IdeaFeedback> ideaFeedback = query.from(IdeaFeedback.class);
	  
	    Root<Idea> idea = query.from(Idea.class);
	  
	    Root<Project> project = query.from(Project.class);
	    TypedQuery<IdeaFeedback> typedQuery = entityManager.createQuery(query
	    		.select(ideaFeedback)
	            .where(builder.and(
	                    builder.equal(project.get("projectId"), projectId),
	                    builder.equal(idea.get("project"), project),	         
	                    builder.equal(ideaFeedback.get("idea"), idea),
	                    builder.equal(ideaFeedback.get("deleteFlag"), 0)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
	
	@Override
	public void deleteIdeaFeedback(IdeaFeedback ideaFeedback) {
		IdeaFeedback ideaFeedbacks = read(ideaFeedback.getIdeaFeedbackID());
		Calendar calendar = Calendar.getInstance();
	    Date date =  calendar.getTime();
		
		
	    ideaFeedbacks.setDeleteFlag(1);
	    ideaFeedbacks.setCreatedDate(date);
		}

}
