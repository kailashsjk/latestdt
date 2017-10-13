package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;






import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Named
public class DTEmpathyHmwQuestionsDAO extends BaseDAO<HmwQuestion, Serializable> implements IDTEmpathyHmwQuestionsDAO{
	public List<HmwQuestion> getHmwQuestionsDetail(int projectId){
				CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<HmwQuestion> query = builder.createQuery(HmwQuestion.class);
		    Root<HmwQuestion> hmwQuestion = query.from(HmwQuestion.class);
		    Root<Media> media = query.from(Media.class);
		    Root<Project> project = query.from(Project.class);
		    TypedQuery<HmwQuestion> typedQuery = entityManager.createQuery(query
		    		.select(hmwQuestion)
		            .where(builder.and(
		                   builder.equal(project.get("projectId"),projectId),
		                   //builder.equal(media.get("project"), project),
		                   builder.equal(hmwQuestion.get("project"), project)
		                    //builder.equal(hmwQuestion.get("deleteFlag"),0)
		            )).distinct(true)
		    );
		    return typedQuery.getResultList();
		}
		
    
	public List<HmwQuestion> getActiveHmwQuestionsDetail(int projectId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<HmwQuestion> query = builder.createQuery(HmwQuestion.class);
    Root<HmwQuestion> hmwQuestion = query.from(HmwQuestion.class);
    Root<Media> media = query.from(Media.class);
    Root<Project> project = query.from(Project.class);
    TypedQuery<HmwQuestion> typedQuery = entityManager.createQuery(query
    		.select(hmwQuestion)
            .where(builder.and(
                   builder.equal(project.get("projectId"),projectId),
                   builder.equal(hmwQuestion.get("project"), project),
                   builder.equal(hmwQuestion.get("deleteFlag"),0)
            )).distinct(true)
    );
    return typedQuery.getResultList();
}
	
	
public List<Object[]> getHmwQuestionsByMediaID(int mediaID){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root hmwQuestions = criteriaQuery.from(HmwQuestion.class);
		criteriaQuery.multiselect(hmwQuestions.get("questionID"),hmwQuestions.get("questionDescription"));
		CriteriaQuery result1 = criteriaQuery.where(criteriaBuilder.equal(hmwQuestions.get("media"),mediaID));
		TypedQuery q = entityManager.createQuery(result1);
		List<Object[]> result = q.getResultList();
		
	
		return result;
		
		
	}		

@Override
public void deleteHmwQuestion(HmwQuestion hmwquestion) {
	HmwQuestion hmwquestions = read(hmwquestion.getQuestionID());
	Calendar calendar = Calendar.getInstance();
    Date date =  calendar.getTime();
	hmwquestions.setDeleteFlag(1);
	hmwquestions.setCreatedDate(date);
	}

@Override
public void activateHmwQuestion(HmwQuestion hmwquestion){
	HmwQuestion hmwquestions = read(hmwquestion.getQuestionID());
	hmwquestions.setDeleteFlag(0);
}

}


