package com.techm.adms.dt.service;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.IdeaFeedbackConversation;
import com.techm.adms.dt.dao.IDTIdeaFeedbackDAO;
import com.techm.adms.dt.dto.IdeaFeedbackDTO;
import com.techm.adms.dt.entity.IdeaFeedback;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTIdeaFeedbackBean implements IDTIdeaFeedbackBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTIdeaFeedbackBean.class);
	
	@Inject
	IDTIdeaFeedbackDAO dtIdeaFeedbackDAO;
	
	@Inject
	IdeaFeedbackConversation ideaFeedbackConversation;
	
	@PersistenceContext
	protected EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void captureIdeaFeedback(IdeaFeedback ideafeedback) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtIdeaFeedbackDAO###"+ dtIdeaFeedbackDAO);
			dtIdeaFeedbackDAO.create(ideafeedback);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	
	@Override
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetailsByProjectID(int projectId){
		List<IdeaFeedback> ideaFeedback=dtIdeaFeedbackDAO.getIdeaFeedbackByProjectId(projectId);
		return ideaFeedbackConversation.fromEntityToDTO(ideaFeedback);
	}

	@Override
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetailsByProjectIDActiveDatas(int projectId){
		
		List<IdeaFeedback> ideaFeedback=dtIdeaFeedbackDAO.getIdeaFeedbackByProjectIdActiveDatas(projectId);
		LOGGER.debug("ideaFeedback>>>>>>"+ideaFeedback);
		return ideaFeedbackConversation.fromEntityToDTO(ideaFeedback);
	}


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteIdeaFeedback(int deleteIdeaFeedback) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			IdeaFeedback existingIdeaFeedback = dtIdeaFeedbackDAO.read(deleteIdeaFeedback);

			LOGGER.debug(existingIdeaFeedback.toString() + "   1####  "
					+ existingIdeaFeedback);
			existingIdeaFeedback.setIdeaFeedbackDescription(existingIdeaFeedback.getIdeaFeedbackDescription());
			LOGGER.debug(existingIdeaFeedback.toString() + "   2####  "
					+ existingIdeaFeedback);
			dtIdeaFeedbackDAO.deleteIdeaFeedback(existingIdeaFeedback);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	
}
