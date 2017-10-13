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
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;
@Named
public class DTIdeaDAO extends BaseDAO<Idea, Serializable> implements IDTIdeaDAO {

@SuppressWarnings("unchecked")
//active only
@Override
public List<Idea> getIdeasByProjectId(int projectId) {
	System.out.println("In idea dao Impl");
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Idea> query = builder.createQuery(Idea.class);
    Root<Idea> idea = query.from(Idea.class);
    Root<Project> project = query.from(Project.class);
    System.out.println("In idea service query");
    TypedQuery<Idea> typedQuery = entityManager.createQuery(query
    		.select(idea)
            .where(builder.and(
            		
            		    builder.equal(project.get("projectId"),projectId),
	                  
	                    builder.equal(idea.get("project"), project),
                        // builder.equal(idea.get("project"),projectId),
                    
                        builder.equal(idea.get("deleteFlag"), 0)
                    
                    
            )).distinct(true)
    );
    return typedQuery.getResultList();
}


//show all
@Override
public List<Idea> getAllIdeasByProjectId(int projectId) {
	System.out.println("In idea dao Impl");
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Idea> query = builder.createQuery(Idea.class);
    Root<Idea> idea = query.from(Idea.class);
    Root<Project> project = query.from(Project.class);
    System.out.println("In idea service query");
    TypedQuery<Idea> typedQuery = entityManager.createQuery(query
    		.select(idea)
            .where(builder.and(
            		
            		    builder.equal(project.get("projectId"),projectId),
	                  
	                    builder.equal(idea.get("project"), project)
                           
            )).distinct(true)
    );
    return typedQuery.getResultList();
}

//delete
@Override
public void deActivate(int ideaId) {
	Idea idea = read(ideaId);
	idea.setDeleteFlag(1);
}

//activate
@Override
public void activateIdea(int ideaId) {
	Idea idea = read(ideaId);
	idea.setDeleteFlag(0);
}

}
