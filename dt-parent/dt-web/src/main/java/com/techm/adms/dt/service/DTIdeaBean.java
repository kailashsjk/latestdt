package com.techm.adms.dt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.IdeaConversation;
import com.techm.adms.dt.dao.IDTIdeaDAO;
import com.techm.adms.dt.dto.IdeaDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;


@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTIdeaBean implements IDTIdeaBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTIdeaBean.class);
	
	@Inject
	IDTIdeaDAO dtIdeaDAO;
	@Inject
	IdeaConversation ideaConversation;
	@PersistenceContext
    protected EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createIdea(Idea idea) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			
			LOGGER.info("In Bean Class dtIdeaDAO###"+ dtIdeaDAO);
			dtIdeaDAO.create(idea);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}
	

//active only
@Override
public List<IdeaDTO> getIdeasDetailsByProjectID(int projectId) {
	List<Idea> ideas = dtIdeaDAO.getIdeasByProjectId(projectId);
	System.out.println("In idea service Impl active only");
	LOGGER.debug("ideas active only>>>>>>"+ideas);
	return ideaConversation.fromEntityToDTO(ideas);
}

//active only
@Override
public List<Idea> getActiveIdeasDetailsByProjectID(int projectId) {
	List<Idea> ideas = dtIdeaDAO.getIdeasByProjectId(projectId);
	System.out.println("In idea service Impl active only");
	LOGGER.debug("ideas active only>>>>>>"+ideas);
	return ideas;
}

//show all
@Override
public List<IdeaDTO> getAllIdeasDetailsByProjectID(int projectId) {
	List<Idea> ideas = dtIdeaDAO.getAllIdeasByProjectId(projectId);
	System.out.println("In idea service Impl show all");
	LOGGER.debug("ideas show all>>>>>>"+ideas);
	return ideaConversation.fromEntityToDTO(ideas);
}
//update
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void updateIdea(Idea updatedIdea) throws DTServiceException{
	LOGGER.info("In Idea Bean Class updateIdea method");
	try{
		Idea existingIdea = dtIdeaDAO.read(updatedIdea.getIdeaId());
		
		LOGGER.debug(existingIdea.toString()+"   1####  "+existingIdea);
		existingIdea.setIdeaDescription(updatedIdea.getIdeaDescription());
		
		LOGGER.debug(existingIdea.toString()+"   2####  "+existingIdea);
		dtIdeaDAO.update(existingIdea);
	}catch(Exception e){
		throw new DTServiceException(e);
	}
}

public Idea getIdeaDetail(int ideaId) throws DTServiceException{
	LOGGER.info("In Idea Bean Class updateIdea method");
	Idea idea = new Idea();
	try{
		idea = dtIdeaDAO.read(ideaId);
	}catch(Exception e){
		throw new DTServiceException(e);
	}
	return idea;
}

public void deleteIdea(int ideaId) throws DTServiceException{
	dtIdeaDAO.deActivate(ideaId);
}



public void activateIdea(int ideaId) throws DTServiceException{
	dtIdeaDAO.activateIdea(ideaId);
}




}

	
