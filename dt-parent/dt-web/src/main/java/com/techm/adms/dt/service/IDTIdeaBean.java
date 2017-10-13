package com.techm.adms.dt.service;

import java.util.List;




import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.IdeaDTO;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.Project;



public interface IDTIdeaBean {
	public void createIdea(Idea idea) throws DTServiceException;
	
	public List<IdeaDTO> getIdeasDetailsByProjectID(int projectId);
	public List<Idea> getActiveIdeasDetailsByProjectID(int projectId) ;

	public void deleteIdea(int ideaId)throws DTServiceException;

	public List<IdeaDTO> getAllIdeasDetailsByProjectID(int projectId)throws DTServiceException;

	public void updateIdea(Idea idea);

	public Idea getIdeaDetail(int ideaId);

	public void activateIdea(int ideaId)throws DTServiceException;


}

