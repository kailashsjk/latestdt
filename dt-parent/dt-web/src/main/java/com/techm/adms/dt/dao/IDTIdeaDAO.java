package com.techm.adms.dt.dao;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.Project;

public interface IDTIdeaDAO extends IBaseDAO<Idea, Serializable>{
	//public List<Idea> getIdeaDetailsByQuestionID(int mediaID);
	
	public List<Idea> getIdeasByProjectId(int projectId);

	public void deActivate(int ideaId);

	public List<Idea> getAllIdeasByProjectId(int projectId);

	public void activateIdea(int ideaId);

	

	
}